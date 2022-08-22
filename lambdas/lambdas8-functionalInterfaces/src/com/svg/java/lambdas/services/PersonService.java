package com.svg.java.lambdas.services;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.lambdas.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
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

    public Optional<Person> getFirstPersonByName(String name) {
        return getAll().stream()
                .filter((p) -> (p.name().contentEquals(name)))
                .findFirst();
    }

}
