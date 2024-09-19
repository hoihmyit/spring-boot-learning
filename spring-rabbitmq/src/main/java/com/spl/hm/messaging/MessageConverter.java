package com.spl.hm.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.timgroup.statsd.StatsDClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class MessageConverter extends QueryMessageConverterBase<MessageResponse> {

    private static final String STAT_PREFIX = MessageConverter.class.getName();
    private static final String STAT_CONVERT_FROM_MESSAGE_READ_ERROR = STAT_PREFIX + ".convertFromMessage.read_error";

    private final ObjectReader responseReader;
    private final StatsDClient statsDClient;

    @Autowired
    public MessageConverter(final ObjectMapper objectMapper, final StatsDClient statsDClient) {
        super(objectMapper);
        this.responseReader = objectMapper.readerFor(MessageResponse.class);
        this.statsDClient = statsDClient;
    }

    @Override
    protected MessageResponse convertFromMessage(final Message message) {
        try {
            final MessageResponse messageResponse = responseReader.readValue(message.getBody());
            messageResponse.setCorrelationId(message.getMessageProperties().getCorrelationId());
            return messageResponse;

        } catch (final IOException e) {
            statsDClient.increment(STAT_CONVERT_FROM_MESSAGE_READ_ERROR);
            throw new MessageConversionException(String.format("Failed to read simple response from message body: %s", new String(message.getBody(), StandardCharsets.UTF_8)), e);
        }
    }
}
