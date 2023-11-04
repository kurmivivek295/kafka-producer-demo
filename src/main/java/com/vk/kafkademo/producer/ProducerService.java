package com.vk.kafkademo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("spring-kafka-demo", msg);
        send.whenComplete((sr, str) -> System.out.println("Send Result: " + sr + " and str: " + str));
    }
}
