package com.spl.hm.springboot_kafka.consumer;

import com.spl.hm.springboot_kafka.dto.UserMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LogManager.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, UserMessage> record, Acknowledgment acknowledgment) {
        try {
            log.info("Consumer received: {}", record.value());

            // process the message here: e.g., save to DB, trigger event, etc.

            // Acknowledge only after successful processing
            acknowledgment.acknowledge();
            log.info("Message acknowledged (offset committed)");

        } catch (Exception e) {
            log.error("Error while processing message: {}, error msg: {}", record.value(), e.getMessage());
            throw e; // Let Spring handle retry and DLT
        }
    }

}
