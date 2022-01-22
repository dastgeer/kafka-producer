package com.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.entity.CarLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarLocationProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    //perform operation with java object
    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(CarLocation carlocation) throws JsonProcessingException {
        //convert this java object to json string format
        String carlocationObj = objectMapper.writeValueAsString(carlocation);
      kafkaTemplate.send("t_carlocation",carlocation.getCarId(),carlocationObj);
    }
}
