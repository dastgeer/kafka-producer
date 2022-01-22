package com.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private ObjectMapper objectMapper =  new ObjectMapper();

    public void sendMessage(Employee employee) throws JsonProcessingException {
       String data = objectMapper.writeValueAsString(employee);
        employee.getEmployeeId();
        kafkaTemplate.send("t_employee",data);
    }
}
