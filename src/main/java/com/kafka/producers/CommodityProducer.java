package com.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommodityProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private ObjectMapper objectmapper = new ObjectMapper();

    public void sendCommodity(Commodity commodity) throws JsonProcessingException {
        log.info("kafka sending commodity {}",commodity);
        String commodityString = objectmapper.writeValueAsString(commodity);
        kafkaTemplate.send("t_commodity",commodity.getName(),commodityString);
    }
}
