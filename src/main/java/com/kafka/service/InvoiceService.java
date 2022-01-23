package com.kafka.service;

import com.kafka.entity.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class InvoiceService {

    private static int count = 0;

    public Invoice generateInvoice(){
        count++;
        Invoice invoice = new Invoice();
        invoice.setInvoiceId("inv-"+count);
        int amount= ThreadLocalRandom.current().nextInt(1,1000);
        invoice.setAmount(amount);
        invoice.setCurrency("usd");
        return invoice;
    }
}
