package com.svg.java.streams.basictypes;


import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 10);
        // Print the numbers in the range ^2
        intStream.map((n) -> n * n).forEach(System.out::println);

        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Get persons age and reduce the list summing the ages
        int totalAge = personList.stream().map(Person::getAge).reduce(0, (age1, age2) -> age1 + age2);
        System.out.printf("The age's total is: %d %n", totalAge);

        // Get persons age and reduce the list summing the ages by using a generic Optional
        OptionalInt optionaltotalAge = personList.stream().mapToInt(Person::getAge).reduce(Integer::sum);
        System.out.println("The age's total is: " + optionaltotalAge);
        // Another option to do the same that in the previous exercise
        personList.stream().mapToInt(Person::getAge).reduce(Integer::sum).ifPresent(System.out::println);
    }
}
