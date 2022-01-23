package com.kafka;

import com.kafka.entity.Employee;
import com.kafka.entity.FoodOrder;
import com.kafka.entity.Invoice;
import com.kafka.producers.EmployeeProducer;
import com.kafka.producers.EvenOddProducer;
import com.kafka.producers.FoodOrderProducer;
import com.kafka.producers.InvoiceProducer;
import com.kafka.service.ImageService;
import com.kafka.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
//@EnableScheduling //is for scheduler
public class KafkaProducerApplication implements CommandLineRunner{
//
//	@Autowired
//	private CustomKafkaProducer customKafkaProducer;

	//@Autowired
	//private KafkaKeyProducer keyProducer;
	private EmployeeProducer employeeProducer;

	//@Autowired
	private FoodOrderProducer foodOrderProducer;

//	@Autowired
	private EvenOddProducer evenOddProducer;

	//@Autowired
	private ImageService imgService;

	@Autowired
	private InvoiceService invoiceservice;

	@Autowired
	private InvoiceProducer invoiceProducer;

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
		//1st imple
//		for(int i=0; i<5;i++){
//			Employee employee = new Employee("emp-"+i,"emplName-"+i, LocalDateTime.now().toString());
//			employeeProducer.sendMessage(employee);
//		}
// 2nd impl
//		FoodOrder fishOrder = new FoodOrder(5,"fish");
//		FoodOrder pizzaOrder = new FoodOrder(7,"pizza");
//		FoodOrder muttonFoodOrder = new FoodOrder(6,"mutton biryani");
//		Thread.sleep(5000);
//		foodOrderProducer.sendOrder(fishOrder);
//		Thread.sleep(5000);
//		foodOrderProducer.sendOrder(pizzaOrder);
//		Thread.sleep(5000);
//		foodOrderProducer.sendOrder(muttonFoodOrder);
//		evenOddProducer.consumeNumber(102);
//		evenOddProducer.consumeNumber(103);
//		evenOddProducer.consumeNumber(104);
//assignment 3
//		imgService.generateImage("png");
//		imgService.generateImage("svg");
//		imgService.generateImage("jpg");
//assignment 4
		for(int i=0;i<10;i++){
			Invoice invoice = invoiceservice.generateInvoice();
			if(i>5){
				invoice.setAmount(-1);
			}
			invoiceProducer.sendInvoice(invoice);
		}
	}
}
