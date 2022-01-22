package com.kafka;

import com.kafka.entity.Employee;
import com.kafka.producers.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling //is for scheduler
public class KafkaProducerApplication implements CommandLineRunner{
//
//	@Autowired
//	private CustomKafkaProducer customKafkaProducer;

	@Autowired
	//private KafkaKeyProducer keyProducer;
	private EmployeeProducer employeeProducer;

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

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("in run method...");
//		for(int i=0; i<30;i++){
//			String key = "key-"+(i%4);
//			String data = "data "+ i +" with key "+ key;
//			System.out.println("printing key" + key +"value "+data);
//			keyProducer.send(key,data);
//		}
//	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("in run method...");
//		for(int i=0; i<5;i++){
//			Employee employee = new Employee("emp-"+i,"emplName-"+i, LocalDateTime.now().toString());
//			employeeProducer.sendMessage(employee);
//		}
	}
}
