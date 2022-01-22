package com.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class CustomKafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("helloTopic",message+Math.random());
    }
}
