package com.spl.hm.messaging;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryMessage {

    private Query query;
    private String replyTo;
    private String correlationId;
    private Integer priority;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "queryType")
    public static abstract class Query<T> {

        private Long queryTimestamp;

        public Long getQueryTimestamp() {
            return queryTimestamp;
        }

        public void setQueryTimestamp(final Long queryTimestamp) {
            this.queryTimestamp = queryTimestamp;
        }

        public abstract T getValue();

        public abstract void setValue(T value);
    }

    public String toString() {
        return String.format("correlationId = [%s] || replyTo = [%s] || priority = [%s]", correlationId, replyTo, priority);
    }
}
