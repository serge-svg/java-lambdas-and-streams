package com.svg.java.lambdas.defaultmethods;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonFilterByName implements PersonFilter {

    private String name;

    @Override
    public boolean test(Person person) {
        return (person.getName().equals(name)) ? true : false;
    }
}
