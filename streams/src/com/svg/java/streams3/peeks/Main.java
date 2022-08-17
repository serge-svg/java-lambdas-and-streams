package com.svg.java.streams3.peeks;

import com.svg.java.domain.Person;
import com.svg.java.services.PersonService;

import java.util.ArrayList;
import java.util.List;

/*
    peek(Consumer <? super T> c) → returns a new Stream that has the same elements,
    but applies the consumer to each of the elements.
    The stream is not changed, the elements may be changed, depending on what does the consumer.
*/
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Example using stream.peek
        personList.stream()
                .peek(System.out::println)
                .filter((Person p) -> p.age() < 35)
                .forEach(Main::print);
    }

    private static void print(Person p) {
        System.out.printf("This person is: %s %s %s %n", p.name(), p.surname(), p.age());
    }

}
