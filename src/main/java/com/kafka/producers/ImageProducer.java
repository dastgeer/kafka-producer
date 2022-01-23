package com.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.entity.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ImageProducer {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendImage(Image image) throws JsonProcessingException {
        String imageObj= objectMapper.writeValueAsString(image);
        kafkaTemplate.send("t_image",image.getType(),imageObj);
        log.info("image producer:{}",imageObj);
    }
}
