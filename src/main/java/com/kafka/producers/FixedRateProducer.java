package com.kafka.producers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
//@Service
public class FixedRateProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private int count = 0;

    //@Scheduled(fixedRate = 1000)
    public void sendMessage(){
      log.info("sending message to kafka..{}",count);
      kafkaTemplate.send("fixedrate","message:"+count);
      count++;
    }

}
