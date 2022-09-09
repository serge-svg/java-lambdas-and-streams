package com.svg.java.streams.streams4.maps;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.ArrayList;
import java.util.Arrays;
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
                .map((p) -> (p.getName().toUpperCase()))
                //.forEach(System.out::println);
                .forEach(Main::print);

        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)); // [1, 2, 3, 4]

        numbers.stream()
                .map(x -> x * x)
                .forEach(System.out::println);

    }

    private static void print(String value) {
        System.out.printf("The value is: %s %n", value);
    }


}
