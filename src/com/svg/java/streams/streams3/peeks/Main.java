package com.svg.java.streams.streams3.peeks;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    peek(Consumer <? super T> c) → returns a new Stream that has the same elements,
    but applies the consumer to each of the elements.
    The stream is not changed, the elements may be changed, depending on what does the consumer.
*/
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        System.out.println("Print persons younger than 35 and at the same time print all values to check it");
        personList.stream()
                .peek(System.out::println)
                .filter((Person p) -> p.getAge() < 35)
                .forEach(Main::print);

        System.out.println("Print the values multiplied by 2 and the original list at the same time");
        List<Integer> list = new ArrayList<>();
        List<Integer> result = Stream.of(1, 2, 3, 4)
                .peek(x -> list.add(x))
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println(result);

        System.out.println("Print the numbers bigger than 8 after multiply values by 2 and the original list at the same time");
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result2 = Stream.of(1, 2, 3, 4)
                .peek(x -> list2.add(x))
                .map(x -> x * 2)
                .filter(n -> n > 8)
                .collect(Collectors.toList());
        System.out.println(list2);
        System.out.println(result2);

        System.out.println("Print the list values and how many there are");
        // For jdk8 the list will be populated, for newer versions peek is not called at all so the list will be empty
        List<Integer> list3 = new ArrayList<>();
        long howMany = Stream.of(1, 2, 3, 4)
                .peek(x -> list3.add(x))
                .count();
        System.out.println(list3);
        System.out.println(howMany);
    }

    private static void print(Person p) {
        System.out.printf("This person is: %s %s %s %n", p.getName(), p.getSurname(), p.getAge());
    }

}
