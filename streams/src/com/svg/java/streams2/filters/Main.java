package com.svg.java.streams2.filters;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.services.PersonService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Example using stream.filter and its own method reference to print the result
        personList.stream()
                .filter((Person p) -> p.age() > 65)
                .forEach(Main::print);

        // Example using stream.filter with a method reference to filter, and an override
        // toString method of Person to print the result
        personList.stream()
                .filter(Person::isRetired)
                .forEach(System.out::println);

    }

    private static void print(Person p) {
        System.out.printf("This person is: %s %s %s %n", p.name(), p.surname(), p.age());
    }

}
