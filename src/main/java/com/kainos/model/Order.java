package com.kainos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Long id;
    private String description;
    private Status status;
    private Long employeeId;
    private Long customerId;
}
