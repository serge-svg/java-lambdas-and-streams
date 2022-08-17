package com.svg.java.services;

import com.svg.java.domain.Person;
import com.svg.java.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    PersonRepository personRepository = new PersonRepository();

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public List<Person> getPersonByName(String name) {
        return getAll().stream()
                .filter((p)->(p.name().contentEquals(name)))
                .collect(Collectors.toList());
    }


}
