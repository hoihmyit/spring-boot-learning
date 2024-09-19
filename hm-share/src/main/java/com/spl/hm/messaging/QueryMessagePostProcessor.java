package com.spl.hm.messaging;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

public class QueryMessagePostProcessor implements MessagePostProcessor {

    private final String replyToQueue;
    private final String correlationId;
    private final int priority;

    public QueryMessagePostProcessor(final String replyToQueue, final String correlationId, final int queryPriority) {
        this.replyToQueue = replyToQueue;
        this.correlationId = correlationId;
        this.priority = queryPriority;
    }

    @Override
    public Message postProcessMessage(final Message message) throws AmqpException {
        message.getMessageProperties().setReplyTo(replyToQueue);
        message.getMessageProperties().setCorrelationId(correlationId);
        message.getMessageProperties().setPriority(priority);

        return message;
    }
}
