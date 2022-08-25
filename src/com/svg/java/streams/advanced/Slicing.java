package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.List;
import java.util.stream.Stream;

public class Slicing {

    public static void main(String[] args) {
        System.out.println("Print numbers from 1 to 10 except the first two");
        Stream.iterate(1, (n)->n+1).limit(10).skip(2).forEach(System.out::println);

        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        System.out.println("Print all person");
        personList.stream().forEach(System.out::println);

        System.out.println("Print all person except the first two");
        personList.stream().skip(2).forEach(System.out::println);

        System.out.println("Print all person older than 30 except the first");
        personList.stream().filter(p -> p.getAge() > 30).skip(1).forEach(System.out::println);




    }

}
