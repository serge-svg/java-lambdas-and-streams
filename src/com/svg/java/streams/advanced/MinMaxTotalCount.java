package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMaxTotalCount {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();
        // Printing the list of persons
        personList.stream().forEach(System.out::println);

        // Get min age with mapToInt and a lambda expresion
        System.out.printf("The min age is: %s %n", personList.stream().mapToInt(person -> person.getAge()).reduce(150, (age1, age2) -> age1 < age2 ? age1 : age2));
        // Get min age with mapToInt and a method reference
        System.out.printf("The min age is: %s %n", personList.stream().mapToInt(Person::getAge).min());

        // Get max age with method reference Person->age, reduce and lambda
        System.out.printf("The max age is: %s %n", personList.stream().mapToInt(Person::getAge).reduce(0, (age1, age2) -> age1 > age2 ? age1 : age2));
        // Get max age with a mapToInt and a method reference
        OptionalInt max = personList.stream().mapToInt(Person::getAge).max();
        if (max.isPresent()) {
            System.out.printf("The max age is: %s %n", max.getAsInt());
        }

        // Get total age with a map, reduce and lambda
        System.out.printf("The total age is: %s %n", personList.stream().map(person -> person.getAge()).reduce(0, (age1, age2) -> age1 + age2));
        // Get total age with a map and a method reference
        System.out.printf("The total age is: %s %n", personList.stream().mapToInt(Person::getAge).sum());

        // Get number of persons
        System.out.printf("The number of persons in the list is: %s \n", personList.stream().count());
        // Get number of retired persons
        System.out.printf("The number of persons in the list is: %s \n", personList.stream().filter(person -> person.isRetired()).count());


    }
}
