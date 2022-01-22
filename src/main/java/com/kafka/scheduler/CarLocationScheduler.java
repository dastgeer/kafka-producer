package com.kafka.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.entity.CarLocation;
import com.kafka.producers.CarLocationProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarLocationScheduler {

    @Autowired
    private CarLocationProducer carLocationProducer;

    private CarLocation car1;
    private CarLocation car2;
    private CarLocation car3;

    public CarLocationScheduler(){
        long currentTime = System.currentTimeMillis();
        car1 = new CarLocation("car-1",currentTime,0);
        car2 = new CarLocation("car-2",currentTime,110);
        car3 = new CarLocation("car-3",currentTime,95);
    }

    @Scheduled(fixedRate = 10000)
    public void generateCarLocation(){
        long currentTime = System.currentTimeMillis();
        car1.setTimestamp(currentTime);
        car2.setTimestamp(currentTime);
        car3.setTimestamp(currentTime);

        car1.setDistance(car1.getDistance()+1);
        car2.setDistance(car2.getDistance()-1);
        car3.setDistance(car3.getDistance()+1);

        try {
            carLocationProducer.sendMessage(car1);

            log.info("car 1 info: {}", car1);
            carLocationProducer.sendMessage(car2);
            log.info("car 2 info: {}", car2);
            carLocationProducer.sendMessage(car3);
            log.info("car 3 info: {}", car3);
        } catch (JsonProcessingException e) {
            log.error("exception occurred while process:{}",e);
         }
    }
}
