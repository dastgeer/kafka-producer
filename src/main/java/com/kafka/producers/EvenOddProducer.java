package com.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EvenOddProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void consumeNumber(int value) throws JsonProcessingException {
        String number = objectMapper.writeValueAsString(value);
        kafkaTemplate.send("t_evenodd",number);
        log.info("even oddd producer numebr :{}",number);
    }
}
