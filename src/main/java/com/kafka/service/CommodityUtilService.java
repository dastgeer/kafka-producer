package com.kafka.service;

import com.kafka.entity.Commodity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CommodityUtilService {

    private static final Map<String, Commodity> COMMODITY_MAP= new HashMap<>();
    private static final String GOLD ="gold";
    private static final String COPPER ="copper";
    private static final String OIL= "oil";

    private static final double MIN_PRICE=0.95;
    private static final double MAX_PRICE= 1.05;


    static{
        COMMODITY_MAP.put(GOLD,new Commodity(GOLD,45000,"ounce",System.currentTimeMillis()));
        COMMODITY_MAP.put(COPPER,new Commodity(COPPER,30000,"tonne",System.currentTimeMillis()));
        COMMODITY_MAP.put(OIL,new Commodity(OIL,15000,"barrel",System.currentTimeMillis()));
    }

    private Commodity getcommodity(String name){
        if(!COMMODITY_MAP.containsKey(name)){
            new IllegalArgumentException("input commodities not found");
        }
         Commodity commodity= COMMODITY_MAP.get(name);
        commodity.setPrice( commodity.getPrice()*ThreadLocalRandom.current().nextDouble(MIN_PRICE,MAX_PRICE));
        commodity.setTimestamp(System.currentTimeMillis());
        return commodity;
    }

    public List<Commodity> getAllCommoditiesDetail(){
        List<Commodity> commoditiesList = new ArrayList<>();
        COMMODITY_MAP.keySet().forEach(name->commoditiesList.add(getcommodity(name)));
        return commoditiesList;
    }
}
