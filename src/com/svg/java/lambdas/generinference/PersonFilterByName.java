package com.svg.java.lambdas.generinference;

public class PersonFilterByName implements Filter<Person> {

    private String name;

    public PersonFilterByName(String name) {
        super();
        this.name = name;
    }

    @Override
    public boolean test(Person person) {
        return (person.getName().equals(name)) ? true : false;
    }
}
