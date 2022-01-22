package com.kafka.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.producers.CommodityProducer;
import com.kafka.service.CommodityUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommodityScheduler {

    @Autowired
    private CommodityUtilService commodityUtilService;

    @Autowired
    private CommodityProducer commodityProducer;

    @Scheduled(fixedRate = 5000)
    public void sendCommodityWithSchedule(){

        commodityUtilService.getAllCommoditiesDetail().forEach(commodity-> {
            try {
                commodityProducer.sendCommodity(commodity);
            } catch (JsonProcessingException e) {
                log.error(" error while sending commodity :{}",e);
            }
        });
    }
}
