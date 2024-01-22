package com.example.demo.kafka;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaProducer {
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Message sent " + message);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("kafka", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("sent message " + message + "with offset " + result.getRecordMetadata().offset());
            } else {
                log.info("unable to send message " + message + "due to" + ex.getMessage());
            }
        });
    }
}
