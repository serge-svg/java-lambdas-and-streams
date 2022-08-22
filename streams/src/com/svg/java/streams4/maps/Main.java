package com.svg.java.streams4.maps;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.services.PersonService;

import java.util.List;

/*
    map(Function <? super T, ? extends R> f) → returns a new Stream of another type (R),
    by converting each T of the Stream to an R using the given function.
*/
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Example using stream.map
        personList.stream()
                .map((p) -> (p.name().toUpperCase()))
                //.forEach(System.out::println);
                .forEach(Main::print);
    }

    private static void print(String value) {
        System.out.printf("The value is: %s %n", value);
    }

}
