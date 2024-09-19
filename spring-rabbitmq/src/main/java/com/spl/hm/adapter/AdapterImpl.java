package com.spl.hm.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spl.hm.async.ResponseHandler;
import com.spl.hm.async.ResponseHandlerFactory;
import com.spl.hm.autoconfigure.MessagingProperties;
import com.spl.hm.constant.StatusCode;
import com.spl.hm.exception.ShareClientException;
import com.spl.hm.exception.ShareServerException;
import com.spl.hm.messaging.MessageResponse;
import com.spl.hm.messaging.QueryMessage;
import com.spl.hm.messaging.QueryMessagePostProcessor;
import com.spl.hm.messaging.QueryRequestFactory;
import com.timgroup.statsd.StatsDClient;
import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@ComponentScan
public class AdapterImpl implements Adapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdapterImpl.class);
    private static final String STAT_PREFIX = AdapterImpl.class.getName();
    private static final String STAT_PUBLISH_REQUEST = STAT_PREFIX + ".publishRequest";
    private static final String STAT_RECEIVE_RESPONSE = STAT_PREFIX + ".receiveResponse";
    private static final String STAT_RECEIVE_RESPONSE_NO_RECEIVER = STAT_RECEIVE_RESPONSE + ".no_receiver";
    private static final String STAT_RECEIVE_RESPONSE_TIME = STAT_RECEIVE_RESPONSE + ".time";

    private static final long TASK_TTL_MILLIS = 60_000;
    private final AsyncRabbitTemplate rabbitTemplate;
    private final StatsDClient statsDClient;
    private final MessagingProperties messagingProperties;
    private final Queue responseQueue;
    private final ObjectMapper objectMapper;
    private final ResponseHandlerFactory responseHandlerFactory;
    private final QueryRequestFactory queryRequestFactory;
    private final Map<String, ResponseHandler> responseHandlers;
    private final AtomicInteger requestNumber;

    @Autowired
    public AdapterImpl(@Qualifier("asyncRabbitTemplate") final AsyncRabbitTemplate rabbitTemplate,
                       final StatsDClient statsDClient,
                       final MessagingProperties messagingProperties,
                       @Qualifier("responseQueue") final Queue responseQueue,
                       final ObjectMapper objectMapper,
                       final ResponseHandlerFactory responseHandlerFactory,
                       final QueryRequestFactory queryRequestFactory) {

        this.rabbitTemplate = rabbitTemplate;
        this.statsDClient = statsDClient;
        this.messagingProperties = messagingProperties;
        this.responseQueue = responseQueue;
        this.objectMapper = objectMapper;
        this.responseHandlerFactory = responseHandlerFactory;
        this.queryRequestFactory = queryRequestFactory;
        this.responseHandlers = new PassiveExpiringMap<>(TASK_TTL_MILLIS);
        this.requestNumber = new AtomicInteger();
    }

    @Override
    public <T> CompletableFuture<T> sendRequest(final Object request, @NotNull final int queryPriority) {
        final String correlationId = String.format("request:%d", requestNumber.getAndIncrement());

        final ResponseHandler responseHandler = responseHandlerFactory.getResponseHandler(request);

        responseHandlers.put(correlationId, responseHandler);

        publishRequest(request, correlationId, queryPriority);

        return responseHandler.getCompletableFuture();
    }

    private void publishRequest(final Object request, final String correlationId, final int queryPriority) {
        final QueryMessage.Query requestQuery = queryRequestFactory.getQueryRequest(request);
        requestQuery.setValue(request);

        LOGGER.debug("Publishing simple request to '{}' with correlation ID '{}'", messagingProperties.getQueryRoutingKey(), correlationId);

        statsDClient.increment(STAT_PUBLISH_REQUEST);

        rabbitTemplate.convertSendAndReceive(messagingProperties.getQueryRoutingKey(), requestQuery, new QueryMessagePostProcessor(responseQueue.getName(), correlationId, queryPriority))
                .addCallback(this::receiveResponse, throwable -> LOGGER.error("Failure processing simple request", throwable));
    }

    private void receiveResponse(final Object response) {
        final MessageResponse messageResponse = (MessageResponse) response;
        final ResponseHandler handler = responseHandlers.remove(messageResponse.getCorrelationId());

        if (handler == null) {
            LOGGER.error("Could not find request matching response from Spring rabbitmq!!!");
            statsDClient.increment(STAT_RECEIVE_RESPONSE_NO_RECEIVER);
            return;
        }

        final long receiverMillisSinceCreation = handler.millisSinceCreation();

        statsDClient.increment(STAT_RECEIVE_RESPONSE);
        statsDClient.gauge(STAT_RECEIVE_RESPONSE_TIME, receiverMillisSinceCreation);
        LOGGER.debug("Spring rabbitmq responded in {} millisecond", receiverMillisSinceCreation);

        if (messageResponse.isSuccess()) {
            handler.onSuccess(objectMapper, messageResponse.getResponseBody());
        } else {
            if (messageResponse.getStatusCode() == StatusCode.UNKNOWN_ERROR) {
                handler.onError(new ShareServerException(messageResponse.getErrorMessage()));
            } else {
                handler.onError(new ShareClientException(messageResponse.getErrorMessage(), messageResponse.getStatusCode()));
            }
        }
    }
}
