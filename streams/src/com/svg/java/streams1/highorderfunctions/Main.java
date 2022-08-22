package com.svg.java.streams1.highorderfunctions;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.services.PersonService;

import java.util.List;

/*
Module - streams1: This module provides usage examples of high order functions.

A higher-order function is a function that does at least one of the following:
* Takes one or more functions as arguments
* Returns a function as its result
 */
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Example using System.out.printf
        personList.stream().forEach(e -> System.out.printf("This person is: %s %s %s %n", e.name(), e.surname(), e.age()));
        // Example using toString
        personList.stream().forEach(e -> System.out.println("Element value is:" + e));
        // Example using toString with method reference
        personList.stream().forEach(System.out::println);
        // Example using a static method as an own method reference
        personList.stream().forEach(Main::print);

    }

    private static void print(Person person) {
        System.out.printf("This person is: %s %s %s %n", person.name(), person.surname(), person.age());
    }

}
