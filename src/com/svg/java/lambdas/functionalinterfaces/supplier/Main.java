package com.svg.java.lambdas.functionalinterfaces.supplier;

import com.svg.java.lambdas.domain.Person;

import java.util.function.Supplier;

/*
  Functional interface Supplier<T> { public T get(); } → used to generate values without input.
  There is no requirement that a new or distinct result be returned each time the supplier is invoked.
 */
public class Main {

    public static void main(String[] args) {

        // Getting a persona through a Supplier functional interface to print the name
        Supplier<Person> getPerson = () -> new Person("name5", "surname5", 11);
        System.out.println(getPerson.get().getName());

        // Using a service to get a signature of a person
        ServiceSignature serviceSignature = new ServiceSignature(new Person("name6", "surname6", 66));
        Supplier<String> personSignature = serviceSignature::getSignatureForPerson;
        System.out.println(personSignature.get());
    }

    private static void printSurname(Person person) {
        System.out.printf("The surname for %s is %s\n", person.getName(), person.getSurname());
    }

}
