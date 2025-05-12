package com.spl.hm.springboot_kafka.service;

import com.spl.hm.springboot_kafka.dto.UserMessage;
import com.spl.hm.springboot_kafka.producer.KafkaProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    private static final Logger log = LogManager.getLogger(UserService.class);
    private final KafkaProducer kafkaProducer;

    public UserService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public UserMessage saveUser(@RequestBody UserMessage userMessage) {
        try {
            kafkaProducer.sendMessage(userMessage);
            log.debug(" Message sent to producer: {}", userMessage);
            return userMessage;
        } catch (Exception e) {
            log.error("Error while sending message to Kafka: {}", userMessage, e);
            throw e;
        }
    }
}
