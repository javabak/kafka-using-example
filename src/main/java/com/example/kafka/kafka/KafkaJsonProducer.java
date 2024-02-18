package com.example.kafka.kafka;

import com.example.kafka.entity.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaJsonProducer {

    KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sentUser(User user) {
        log.info("sent user to the topic");
        kafkaTemplate.send("user-topic",user);
    }
}
