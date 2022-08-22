package com.svg.java.lambdas.functionalinterfaces.consumer;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.lambdas.services.PersonService;

import java.util.List;
import java.util.function.Consumer;

/*
  Functional interface Consumer, represents an operation that accepts a single input argument and returns no
  result, just operate with the argument. Unlike most other functional interfaces, {@code Consumer} is expected
  to operate via side-effects.
 */
public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();

        // Functional Interface - Consumer name
        personList.stream().forEach((p)-> System.out.println(p.name()));

        Consumer<Person> consumerName = (p)-> System.out.println(p.name());
        personList.stream().forEach(consumerName);


        // Functional Interface - Consumer surname
        personList.stream().forEach(Main::printSurname);

        Consumer<Person> consumerSurname = Main::printSurname;
        personList.stream().forEach(consumerSurname);

        // Functional Interface - Consumer andThen
        Consumer<Person> combinedConsumer =  consumerName.andThen(consumerSurname);
        personList.stream().forEach(combinedConsumer);

        consumerName.accept(new Person("Leo", "Messi", 10));
    }

    private static void printSurname(Person person) {
        System.out.printf("The surname for %s is %s\n", person.name(), person.surname());
    }

}
