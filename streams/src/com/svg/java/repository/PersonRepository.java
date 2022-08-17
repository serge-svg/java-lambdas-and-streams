package com.svg.java.repository;

import com.svg.java.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("name1", "surname2", 71));
        personList.add(new Person("name3", "surname3", 33));
        personList.add(new Person("name2", "surname1", 82));
        return personList;
    }

}
