package com.svg.java.streams.streams7.optionals;


import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        personList.stream().forEach((p) -> {System.out.println(p.name());});

        Optional<Person> personName = personService.getFirstPersonByName("name2");
        if (personName.isPresent()) {
            System.out.println(personName.toString());
        }

        personName = personService.getFirstPersonByName("name5");
        if (personName.isPresent()) {
            System.out.println(personName.toString());
        }

    }

}
