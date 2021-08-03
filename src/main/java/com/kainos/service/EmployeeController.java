package com.kainos.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kainos.db.Database;
import com.kainos.model.Employee;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    List<Employee> all() {
        return Database.employees;
    }
}
