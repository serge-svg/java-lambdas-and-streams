package com.svg.java.streams.repository;


import com.svg.java.streams.domain.Person;
import com.svg.java.streams.domain.Sport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonRepository {

    static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("name1", "surname2", 71, Arrays.asList(new Sport("Padel", 1.5), new Sport("Soccer", 1.5))));
        personList.add(new Person("name2", "surname3", 33, Arrays.asList(new Sport("Cycling", 3))));
        personList.add(new Person("name3", "surname4", 71, Arrays.asList(new Sport("Cycling", 3), new Sport("Running", 2))));
        personList.add(new Person("name4", "surname5", 22, Arrays.asList(new Sport("Running", 2))));
        personList.add(new Person("name5", "surname1", 22, Arrays.asList(new Sport("Running", 2), new Sport("Padel", 1.5))));
    }

    public List<Person> getAll() {
        return personList;
    }

}
