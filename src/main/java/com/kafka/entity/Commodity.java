package com.kafka.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Commodity {

    private String name;
    private double price;
    private String measurement;
    private long timestamp;
}
