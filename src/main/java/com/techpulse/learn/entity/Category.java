package com.techpulse.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

    private Long id;
    private String name;
    private String description;
}
