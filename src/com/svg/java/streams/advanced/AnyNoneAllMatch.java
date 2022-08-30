package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.domain.Sport;
import com.svg.java.streams.services.PersonService;

import java.util.List;

public class AnyNoneAllMatch {

    public static void main(String[] args) {
        List<Person> personList = new PersonService().getAll();
        // Print all sports in the list
        personList.stream()
                .flatMap(person -> person.getSportList().stream())
                .forEach(System.out::println);

        // Print whether 'Padel' is on the list
        System.out.printf("Is there Padel on the list: %b %n", personList.stream()
                .flatMap(person -> person.getSportList().stream())
                .anyMatch(sport -> sport.name().contentEquals("Padel")));

        // Print whether 'Surf' is on the list
        System.out.printf("Is there Surf on the list: %b %n", personList.stream()
                .flatMap(person -> person.getSportList().stream())
                .anyMatch(sport -> sport.name().contentEquals("Surf")));

        // Print whether there is not 'Surf' on the list
        System.out.printf("Is not there Surf on the list: %b %n", personList.stream()
                .flatMap(person -> person.getSportList().stream())
                .noneMatch(sport -> sport.name().contentEquals("Surf")));

        // Print whether there is not 'Surf' on the list
        System.out.printf("Are all sport's name longer than 3 characters: %b %n", personList.stream()
                .flatMap(person -> person.getSportList().stream())
                .allMatch(sport -> sport.name().length() > 3));

        System.out.printf("Are : %s %n", personList.stream()
                .map(person -> person.getName().toUpperCase())
                .count()
        );

    }

}
