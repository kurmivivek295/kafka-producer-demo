package com.vk.kafkademo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("msg") String msg) {
        producerService.sendMessage(msg);
        return ResponseEntity.ok("Message has been sent");
    }
}
