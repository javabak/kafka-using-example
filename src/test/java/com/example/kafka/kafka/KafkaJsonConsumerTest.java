//package com.example.kafka.kafka;
//
//import com.example.kafka.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//import static org.awaitility.Awaitility.await;
//
//@Slf4j
//@Testcontainers
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class KafkaJsonConsumerTest {
//
//    @Container
//    static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest").asCompatibleSubstituteFor("wurstmeister/kafka"));
//
//    @DynamicPropertySource
//    public static void initKafkaProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
//    }
//
//    @Autowired
//    private KafkaTemplate<String, User> kafkaTemplate;
//
//    @Test
//    public void testConsumeUser() {
//        log.info("testConsumeUser method execution started...");
//        User user = new User(1, "name", "lastName");
//        kafkaTemplate.send("user-kafka", user);
//        log.info("testConsumeUser method execution ended...");
//        await().pollInterval(Duration.ofSeconds(3))
//                .atMost(10, TimeUnit.SECONDS)
//                .untilAsserted(()-> {
//
//        });
//    }
//}
