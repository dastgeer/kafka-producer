package com.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class KafkaKeyProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String key,String data){
        kafkaTemplate.send("multipartition",key,data);
    }

}
