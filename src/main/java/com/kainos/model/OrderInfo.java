package com.kainos.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderInfo {
    private Employee employee;
    private Order order;
    private Customer customer;
    private String url;
}
