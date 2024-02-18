package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class KafkaConfig {

    @Bean
    public NewTopic messageTopic() {
        return new NewTopic("kafka", 10, (short) 3);
    }


    @Bean
    public NewTopic jsonTopic() {
        return new NewTopic("user-kafka", 10, (short) 10);
    }
}
