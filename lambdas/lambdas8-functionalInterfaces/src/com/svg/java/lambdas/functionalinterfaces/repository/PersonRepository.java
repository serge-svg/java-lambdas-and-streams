package com.svg.java.lambdas.functionalinterfaces.repository;

import com.svg.java.lambdas.functionalinterfaces.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("name1", "surname2", 71));
        personList.add(new Person("name2", "surname3", 33));
        personList.add(new Person("name3", "surname4", 82));
        personList.add(new Person("name4", "surname1", 22));
    }

    public List<Person> getAll() {
        return personList;
    }

}
