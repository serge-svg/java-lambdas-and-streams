package com.svg.java.filtering;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonFilterByName implements PersonFilter {

    private String name;

    @Override
    public boolean test(Person person) {
        return (person.getName().equals(name)) ? true : false;
    }
}
