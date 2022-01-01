package com.kafka.producer;

import com.kafka.producer.service.CustomKafkaProducer;
import com.kafka.producer.service.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling is for scheduler
public class KafkaProducerApplication implements CommandLineRunner{
//
//	@Autowired
//	private CustomKafkaProducer customKafkaProducer;

	@Autowired
	private KafkaKeyProducer keyProducer;

	public static void main(String[] args) {
		System.out.println("before run main...");
		SpringApplication.run(KafkaProducerApplication.class, args);
		System.out.println("after run main,,,");
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("in run method...");
//	//	customKafkaProducer.sendMessage("hello1..");
//	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("in run method...");
		for(int i=0; i<30;i++){
			String key = "key-"+(i%4);
			String data = "data "+ i +" with key "+ key;
			System.out.println("printing key" + key +"value "+data);
			keyProducer.send(key,data);
		}
	}
}
