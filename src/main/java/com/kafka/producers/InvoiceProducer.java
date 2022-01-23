package com.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.entity.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InvoiceProducer {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendInvoice(Invoice invoice) throws JsonProcessingException {
        String invoiceObj = mapper.writeValueAsString(invoice);
        kafkaTemplate.send("t_invoice",invoice.getInvoiceId(),invoiceObj);
        log.info("invoice producer sent data:{}",invoiceObj);
    }
}
