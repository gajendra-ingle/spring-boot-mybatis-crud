package com.techpulse.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
    private Integer stockQuantity;
    private Boolean isActive;
}