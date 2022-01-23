package com.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.entity.FoodOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private ObjectMapper objectmapper = new ObjectMapper();

    public void sendOrder(FoodOrder foodOrder) throws JsonProcessingException {
        String foodOrderObj = objectmapper.writeValueAsString(foodOrder);
        log.info("food order producer: {}",foodOrderObj);
        kafkaTemplate.send("t_foodorder",foodOrderObj);
    }
}
