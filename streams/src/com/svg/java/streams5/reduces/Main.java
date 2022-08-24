package com.svg.java.streams5.reduces;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.services.PersonService;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

/*
    Reductions are a special type of terminal operation where all of the contents of the stream are combined into a single primitive or Object
*/
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Reduce adding up int values
        int result1 = personList.stream()
                .mapToInt(person -> person.age())
                .reduce(0, (age1, age2) -> age1 + age2);
        System.out.printf("Result: %s %n", result1);

        // Reduce adding up optionalInt values
        OptionalInt result2 = personList.stream()
                .mapToInt(person -> person.age())
                .reduce((age1, age2)-> age1 + age2);
        System.out.printf("Result: %s %n", result2);

        // Reduce to concat string
        Stream<String> myStream1 = Stream.of("h","e","l","l","o!");
        String result = myStream1.reduce("", (res, current) -> res + current);
        System.out.println(result);

        // Reduce to concat string with method reference
        Stream<String> myStream2 = Stream.of("h","e","l","l","o!");
        myStream2.reduce(String::concat).ifPresent(System.out::println);
    }

    private static void print(String value) {
        System.out.printf("The value is: %s\n", value);
    }

}
