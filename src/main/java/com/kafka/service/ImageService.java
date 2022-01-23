package com.kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.entity.Image;
import com.kafka.producers.ImageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

//@Service
@Slf4j
public class ImageService {

    @Autowired
    private ImageProducer imageProducer;

    private int count;

    public void generateImage(String imgType) throws JsonProcessingException {
        count++;
        int size = ThreadLocalRandom.current().nextInt(100,1000);
        Image image = new Image("img-"+count,size,imgType);
        imageProducer.sendImage(image);
    }
}
