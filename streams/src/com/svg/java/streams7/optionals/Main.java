package com.svg.java.streams7.optionals;

import com.svg.java.domain.Person;
import com.svg.java.services.PersonService;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();
        System.out.println();

    }

}
