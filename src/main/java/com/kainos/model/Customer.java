package com.kainos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private boolean isCorporate;
}
