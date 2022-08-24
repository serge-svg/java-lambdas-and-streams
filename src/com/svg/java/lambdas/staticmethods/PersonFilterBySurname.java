package com.svg.java.lambdas.staticmethods;

public class PersonFilterBySurname implements PersonFilter {

    private String surname;

    public PersonFilterBySurname(String surname) {
        this.surname = surname;
    }

    public boolean test(Person person) {
        return (person.getSurname().equals(surname)) ? true : false;
    }
}
