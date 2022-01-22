package com.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class KafkaConfig {
    // this is property which is used for overriding kafka properties in consumer & producer side
    //it will by default use and override proprties from application.proprties/ application .yml but it is used for manually configuration also
    @Autowired
    private KafkaProperties kafkaProperties;
//rememebr here in producer side producer factory of type string, string
    @Bean
    public ProducerFactory<String,String> producerFactory(){
        Map<String, Object> kafkaCustomerPropertiesMap  = kafkaProperties.buildProducerProperties();
        kafkaCustomerPropertiesMap.put(ProducerConfig.METADATA_MAX_AGE_CONFIG,"180000");
        return new DefaultKafkaProducerFactory<>(kafkaCustomerPropertiesMap);
    }

    //in producer if we have overrided producerFactory then we must have to override KafkaTemplate as well in producer side
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<String,String>(producerFactory());
    }

   // Kafka-topic.bat --bootstrap-server  localhost:9092 --alter --topic topc_namae --partitions 2
    // means adding one more partion to existing topic it means it is called
    // rebalcncingthe producer & consumer both side,usmer consumercoordinator it will be assign new partiotin to consumer group consumer instance,at producer side it
    // will be partitionassigner will be used to assigned data to new partition based on hashkey of it is or coming data specific to this new partition or based on hasing technic
    // message would be distributed to kafka. Rebalancing is happening by deafult by kafka confugured time 5 mins. But we can change using property in metadata.we can
    // adjust by using proprty metadata.max.age.ms this configuration preseent in both side producer & consumer.

}
