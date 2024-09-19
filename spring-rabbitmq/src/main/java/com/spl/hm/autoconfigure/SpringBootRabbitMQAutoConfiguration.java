package com.spl.hm.autoconfigure;

import com.spl.hm.messaging.MessageConverter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import java.util.UUID;

@SpringBootConfiguration
public class SpringBootRabbitMQAutoConfiguration {

    @Configuration
    @EnableConfigurationProperties({MessagingProperties.class})
    @ComponentScan({"com.spl.hm"})
    static class MessagingConfiguration {

        private final MessagingProperties messagingProperties;

        @Autowired
        public MessagingConfiguration(final MessagingProperties messagingProperties) {
            Assert.hasText(messagingProperties.getHost(), "Spring messaging host is required in 'spring.messaging.host'");
            Assert.hasText(messagingProperties.getUsername(), "Spring messaging username is required in 'spring.messaging.username'");
            Assert.hasText(messagingProperties.getPassword(), "Spring messaging password is required in 'spring.messaging.password'");
            Assert.hasText(messagingProperties.getVirtualHost(), "Spring messaging virtual host is required in 'spring.messaging.virtual-host'");
            Assert.hasText(messagingProperties.getQueryRoutingKey(), "Spring query routing key is required in 'spring.messaging.query-routing-key'");
            Assert.hasText(messagingProperties.getResponseQueuePrefix(), "Spring response queue name prefix is required in 'spring.messaging.response-queue-prefix'");
            this.messagingProperties = messagingProperties;
        }

        @Bean("connectionFactory")
        ConnectionFactory connectionFactory() {
            final CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
            connectionFactory.setHost(messagingProperties.getHost());
            connectionFactory.setUsername(messagingProperties.getUsername());
            connectionFactory.setPassword(messagingProperties.getPassword());
            connectionFactory.setVirtualHost(messagingProperties.getVirtualHost());
            return connectionFactory;
        }

        @Bean("responseQueue")
        Queue responseQueue(final Environment environment) {
            final String queueName = String.format("%s%s-%s-%s-%s",
                    messagingProperties.getResponseQueuePrefix(),
                    environment.getProperty("CLIENT", "local"),
                    environment.getProperty("ENVIRONMENT", "local"),
                    environment.getProperty("SERVICE", "local"),
                    UUID.randomUUID());

            return QueueBuilder.durable(queueName)
                    .withArgument("x-expires", messagingProperties.getTtlQueuesInMillis())
                    .withArgument("x-message-ttl", messagingProperties.getTtlMessageQueuesInMillis())
                    .build();
        }

        @Bean("rabbitAdmin")
        RabbitAdmin rabbitAdmin(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
            RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
            return rabbitAdmin;
        }

        @Bean("rabbitTemplate")
        RabbitTemplate rabbitTemplate(@Qualifier("connectionFactory") ConnectionFactory connectionFactory, MessageConverter messageConverter) {
            RabbitTemplate responseRabbitTemplate = new RabbitTemplate(connectionFactory);
            responseRabbitTemplate.setMessageConverter(messageConverter);
            return responseRabbitTemplate;
        }

        @Bean("asyncRabbitTemplate")
        AsyncRabbitTemplate asyncRabbitTemplate(@Qualifier("rabbitTemplate") RabbitTemplate rabbitTemplate, @Qualifier("responseQueue") Queue responseQueue) {
            rabbitTemplate.setRoutingKey(messagingProperties.getQueryRoutingKey());

            final SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer(connectionFactory());
            listenerContainer.setQueues(responseQueue);
            listenerContainer.setMaxConcurrentConsumers(messagingProperties.getMaxConcurrentConsumers());
            listenerContainer.setConcurrentConsumers(messagingProperties.getConcurrentConsumers());
            listenerContainer.setPrefetchCount(messagingProperties.getPrefetchCount());
            return new AsyncRabbitTemplate(rabbitTemplate, listenerContainer);
        }
    }
}
