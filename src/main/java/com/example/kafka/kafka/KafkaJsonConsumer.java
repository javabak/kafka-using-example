package com.example.demo.kafka;

import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaJsonConsumer {


    @KafkaListener(topics = "user-kafka", groupId = "myGroup")
    public void consumeUser(User user) {
      log.info("consume user -> " + user);
    }
}
