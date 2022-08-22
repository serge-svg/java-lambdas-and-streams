package com.svg.java.lambdas.functionalinterfaces.predicate;

import com.svg.java.lambdas.domain.Person;
import com.svg.java.lambdas.services.PersonService;

import java.util.List;
import java.util.function.Predicate;

/*
    Predicate<T> { public boolean test(T t);} → Given an input decides for true or false
    (usually used for removing or filtering)
*/
public class Main {

    public static void main(String[] args) {
        // Getting a Person whose name is name2 or name3 and is not retired
        PersonService personService = new PersonService();
        List<Person> personList = personService.getAll();
        System.out.println("Persons with name2:");
        Predicate<Person> pName2 = (p) -> p.name().contentEquals("name2");
        personList.stream().filter(pName2).forEach(System.out::println);

        System.out.println("\nPersons with name2 or name3:");
        Predicate<Person> pName2OrName3 = pName2.or((p) -> p.name().contentEquals("name3"));
        personList.stream().filter(pName2OrName3).forEach(System.out::println);

        System.out.println("\nPersons with name2 or name3 whose are retired:");
        Predicate<Person> pName2OrName3AndAreRetired = pName2.or((p) -> p.name().contentEquals("name3")).and((p) -> p.isRetired());
        personList.stream().filter(pName2OrName3AndAreRetired).forEach(System.out::println);

        System.out.println("\nPersons whose are retired:");
        Predicate<Person> pRetired = (p) -> p.isRetired();
        personList.stream().filter(pRetired).forEach(System.out::println);

        System.out.println("\nPersons whose are not retired:");
        Predicate<Person> pNotRetired = pRetired.negate();
        personList.stream().filter(pNotRetired).forEach(System.out::println);

    }
}
