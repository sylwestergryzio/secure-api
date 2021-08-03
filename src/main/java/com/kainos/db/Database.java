package com.kainos.db;

import java.util.Arrays;
import java.util.List;

import com.kainos.model.Customer;
import com.kainos.model.Employee;
import com.kainos.model.Order;
import com.kainos.model.Status;

public class Database {
    public static List<Employee> employees = Arrays.asList(
        new Employee(1L, "Bruce Wayne", "Sales Manager"),
        new Employee(2L, "Peter Parker", "Salesman"),
        new Employee(3L, "Tony Stark", "Boss")
    );

    public static List<Order> orders = Arrays.asList(
        new Order(1L, "Black Jacket and Trousers", Status.NEW, 1L, 1L),
        new Order(2L, "Turbo boost", Status.IN_PROGRESS, 1L, 2L),
        new Order(3L, "Diet Coke", Status.COMPLETED, 3L, 3L)
    );

    public static List<Customer> customers = Arrays.asList(
        new Customer(1L, "Brad Pitt", false),
        new Customer(2L, "Lewis Hamilton", false),
        new Customer(3L, "Amazon", true)
    );
}
