package com.svg.java.streams.streams7.collectors;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    The data in a stream may be collected by using the method collect().
    Collectors may be used to convert from a stream to a list
*/
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        Stream<Person> myStream = personList.stream();
        //myStream.filter((p) -> p.age() > 30).forEach(System.out::println);

        List<Person> myList = myStream.filter((p) -> p.getAge() > 30)
                .collect(Collectors.toList());
        for (Person person : myList) {
            System.out.println(person.toString());
        }
    }

    private static void print(String value) {
        System.out.printf("The value is: %s\n", value);
    }

}
