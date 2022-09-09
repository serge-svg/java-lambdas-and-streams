package com.svg.java.lambdas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private String name;
    private String surname;
    private int age;

    public boolean isRetired() {
        return this.age > 65;
    }
}