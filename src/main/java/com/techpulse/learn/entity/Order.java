package com.techpulse.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private String productName;
    private Double price;
    private Integer quantity;

}
