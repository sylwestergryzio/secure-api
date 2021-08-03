package com.kainos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kainos.db.Database;
import com.kainos.model.Order;
import com.kainos.model.OrderInfo;

@RestController
public class OrderController {
    @GetMapping("/orders")
    public List<OrderInfo> all() {
        return Database.orders.stream()
            .map(this::mapOrder)
            .collect(Collectors.toList());
    }

    @GetMapping("/orders/{id}")
    public OrderInfo findOne(@PathVariable Long id) {
        return mapOrder(Database.orders
            .stream()
            .filter(o -> o.getId().equals(id))
            .findFirst().get());
    }

    private OrderInfo mapOrder(Order order) {
        return OrderInfo.builder()
            .order(order)
            .employee(
                Database.employees.stream()
                    .filter(e -> e.getId().equals(order.getEmployeeId())).findFirst().get()
            )
            .customer(Database.customers.stream()
                .filter(c -> c.getId().equals(order.getCustomerId())).findFirst().get()
            )
            .url("http://well-known.org/orders/" + order.getId())
            .build();
    }
}
