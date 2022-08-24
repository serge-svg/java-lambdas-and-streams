package com.svg.java.lambdas.functionalinterfaces.biconsumer;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.lambdas.service.PersonService;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/*
    BiConsumer<T, U> { public void accept(T t, U u);} → The same of consumer, but for two different parameters
 */
public class Main {

    public static void main(String[] args) {

        // Using Biconsumer to print names of two persons
        BiConsumer<Person, Person> biConsumerNames = (p1, p2) -> System.out.printf("Person: %s %s", p1.name(), p2.name());
        biConsumerNames.accept(new Person("nameA", "surnameA", 90), new Person("nameB", "surnameB", 43));

        // Create a map with name as key and person as value for all the persons in the list and print(key values) using a biConsumer
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::name, person -> person));
        personMap.forEach(Main::printMapPerson);

    }

    // Method used as biConsumer
    private static void printMapPerson(String key, Person person) {
        System.out.printf("Name is %s and surname is %s %n", key, person.surname());
    }

}
