package com.spl.hm.springboot_kafka.producer;

import com.spl.hm.springboot_kafka.dto.UserMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LogManager.getLogger(KafkaProducer.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic.dlt-name}")
    private String dltTopicName;

    @Value("${spring.kafka.producer.max-retries}")
    private int maxRetries;

    private final KafkaTemplate<String, UserMessage> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, UserMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserMessage userMessage) {
        int attempts = 0;
        boolean success = false;
        String key = String.valueOf(userMessage.getId());

        while (attempts < maxRetries && !success) {
            try {
                kafkaTemplate.send(topicName, key, userMessage).get(); // block until ack
                log.info("Sent msg successful to topic: {}, key: {}, value: {}", topicName, key, userMessage);
                success = true;

            } catch (Exception e) {
                attempts++;
                log.error("Kafka send failed (attempt {}): {}", attempts, e.getMessage());
                if (attempts == maxRetries) {
                    log.error("Giving up after {} attempts!", maxRetries);
                    // send to DLT topic
                    try {
                        kafkaTemplate.send(dltTopicName, userMessage).get();
                        log.info("Sent to DLT topic: {}, key: {}, id: {}", dltTopicName, key, userMessage.getId());
                    } catch (Exception dltEx) {
                        log.error("Failed to send to DLT: {}", dltEx.getMessage());
                    }
                }
            }
        }
    }
}
