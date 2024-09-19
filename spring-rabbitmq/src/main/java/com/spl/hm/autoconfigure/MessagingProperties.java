package com.spl.hm.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.messaging")
@Getter
@Setter
public class MessagingProperties {

    private String host = "localhost";
    private String username = "";
    private String password = "";
    private String virtualHost = "";
    private String queryRoutingKey = "queue.query-message-handle";
    private String responseQueuePrefix = "queue.query-response.";
    private int maxConcurrentConsumers = 10;
    private int concurrentConsumers = 5;
    private int prefetchCount = 250;
    private int ttlQueuesInMillis = 60000;
    private int ttlMessageQueuesInMillis = 30000;
}
