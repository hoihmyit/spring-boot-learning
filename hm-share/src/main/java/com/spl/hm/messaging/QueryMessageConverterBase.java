package com.spl.hm.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.lang.NonNull;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public abstract class QueryMessageConverterBase<RESPONSE_TYPE> implements MessageConverter {

    private final ObjectWriter requestWriter;

    public QueryMessageConverterBase(final ObjectMapper objectMapper) {
        objectMapper.registerSubtypes(new NamedType(SimpleQuery.class, QueryType.simpleQuery));
        requestWriter = objectMapper.writerFor(QueryMessage.Query.class);
    }

    @Override
    @NonNull
    public Message toMessage(@NonNull final Object payload,
                             @NonNull final MessageProperties messageProperties) throws MessageConversionException {

        if (payload instanceof QueryMessage.Query) {
            try {
                return new Message(requestWriter.writeValueAsString(payload).getBytes(StandardCharsets.UTF_8.name()), messageProperties);
            } catch (final JsonProcessingException | UnsupportedEncodingException e) {
                throw new MessageConversionException("Failed to create message with given payload", e);
            }
        }

        throw new MessageConversionException("Message payload is not a valid Query");
    }

    @Override
    @NonNull
    public RESPONSE_TYPE fromMessage(@NonNull final Message message) throws MessageConversionException {
        return convertFromMessage(message);
    }

    protected abstract RESPONSE_TYPE convertFromMessage(final Message message);
}
