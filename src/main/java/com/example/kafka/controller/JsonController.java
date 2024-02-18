package com.example.kafka.controller;

import com.example.kafka.entity.User;
import com.example.kafka.kafka.KafkaJsonProducer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JsonController {

    KafkaJsonProducer kafkaProducer;

    @Autowired
    public JsonController(KafkaJsonProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser(@RequestBody User user) {
        log.info("user successfully sent");
        kafkaProducer.sentUser(user);
        return ResponseEntity.ok("user successfully sent");
    }
}
