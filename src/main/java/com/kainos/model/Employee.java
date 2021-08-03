package com.kainos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String role;
}
