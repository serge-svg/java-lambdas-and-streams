package com.svg.java.streams.streams5.flatmaps;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.domain.Sport;
import com.svg.java.streams.services.PersonService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    flatMap(Function <? super T, ? extends Stream<? extends R>> f) → returns a new Stream of another type R which
    combines all the streams generated from each T using the function provided
 */
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Print all persons with their sports
        personList.stream()
                .forEach(System.out::println);

        // Print all persons with their names and surnames
        personList.stream()
                .map(person -> person.getName() + " " + person.getSurname())
                .forEach(System.out::println);

        // Print every sport of each person
        personList.stream()
                .flatMap(person -> person.getSports().stream())
                .map(d -> d.name())
                .forEach(System.out::println);

        // Print every sport of each person without repetition
        System.out.println("The list of sports is: ");
        personList.stream()
                .flatMap(person -> person.getSports().stream())
                .map(d -> d.name())
                .distinct()
                .forEach(System.out::println);

        // Print total hours persons play
        System.out.printf("Total hours played is: %s %n",
            personList.stream()
                .flatMap(person -> person.getSports().stream())
                .mapToDouble(Sport::hours)
                .sum()
        );

        // Print total hours persons play Padel
        System.out.printf("Total hours played in padel %s %n",
            personList.stream()
                .flatMap(person -> person.getSports().stream())
                .filter(d -> d.name().contentEquals("Padel"))
                .mapToDouble(Sport::hours)
                .sum()
        );


        List<List<Integer>> bidimensionalList = new ArrayList<List<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(1, 2)),
                new ArrayList<Integer>(Arrays.asList(3, 4))
        ));

        System.out.printf("Flatting lists: %s %n",
            bidimensionalList
                .stream()
                .flatMap( internalList -> internalList.stream())
                .collect(Collectors.toList())
        );

    }

}
