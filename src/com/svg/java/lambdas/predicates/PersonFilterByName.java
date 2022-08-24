package com.svg.java.lambdas.predicates;

import java.util.function.Predicate;

public class PersonFilterByName implements Predicate<Person> {

    private String name;

    public PersonFilterByName(String name) {
        this.name = name;
    }

    public boolean test(Person person) {
        return (person.getName().equals(name)) ? true : false;
    }
}
