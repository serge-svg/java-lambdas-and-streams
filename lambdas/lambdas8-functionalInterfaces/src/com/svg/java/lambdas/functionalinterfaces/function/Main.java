package com.svg.java.lambdas.functionalinterfaces.function;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.lambdas.service.PersonService;

import java.util.List;
import java.util.function.Function;

/*
  Functional interface Function, represents a function that accepts one argument and produces a result.
 */
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Functional Interface - The first part 'map', uses a Function and second part 'foreach', uses a Consumer
        personList.stream().map((p)->p.name()).forEach(System.out::println);

        Function<Person, String> mappingByName = (p) -> p.name();
        personList.stream().map(mappingByName).forEach(System.out::println);

        Function<Person, Integer> mappingByAge = (p) -> p.age();
        personList.stream().map(mappingByAge).forEach(System.out::println);

        Function<Person, String> mappingBySurname = (p) -> p.surname();
        personList.stream().map(mappingBySurname).forEach(System.out::println);

        // Other example
        Function<Integer,String> converter = (i)-> Integer.toString(i);
        Function<String, Integer> reverse = (s)-> Integer.parseInt(s);
        System.out.println(converter.apply(3).length());
        System.out.println(converter.andThen(reverse).apply(30).byteValue());
    }

    private static void printSurname(Person person) {
        System.out.printf("The surname for %s is %s\n", person.name(), person.surname());
    }

}
