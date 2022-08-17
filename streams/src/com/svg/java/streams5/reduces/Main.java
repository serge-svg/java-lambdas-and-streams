package com.svg.java.streams5.reduces;

import com.svg.java.domain.Person;
import com.svg.java.services.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/*
    Reductions are a special type of terminal operation where all of the contents of the stream are combined into a single primitive or Object
*/
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        int result1 = personList.stream()
                .mapToInt(person -> person.age())
                .reduce(0, (age1, age2)-> age1 + age2);
        System.out.printf("Result: %s %n", result1);

        OptionalInt result2 = personList.stream()
                .mapToInt(person -> person.age())
                .reduce((age1, age2)-> age1 + age2);
        System.out.printf("Result: %s %n", result2);

    }

    private static void print(String value) {
        System.out.printf("The value is: %s\n", value);
    }

}
