package com.svg.java.lambdas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private final String name;
    private final String surname;
    private final int age;

    public boolean isRetired() {
        return this.age > 65;
    }
}