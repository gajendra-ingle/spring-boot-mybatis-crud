package com.techpulse.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private Long isDeleted; // 0 = active, 1 = deleted
    private List<Order> orders;

}
