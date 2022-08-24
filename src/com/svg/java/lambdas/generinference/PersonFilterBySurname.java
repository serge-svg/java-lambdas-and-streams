package com.svg.java.lambdas.generinference;

public class PersonFilterBySurname implements Filter<Person> {

    private String surname;

    public PersonFilterBySurname(String surname) {
        super();
        this.surname = surname;
    }

    @Override
    public boolean test(Person person) {
        return (person.getSurname().equals(surname)) ? true : false;
    }
}
