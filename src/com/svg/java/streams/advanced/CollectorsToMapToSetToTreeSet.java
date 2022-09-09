package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsToMapToSetToTreeSet {

    public static void main(String[] args) {

        PersonService personService = new PersonService();
        List<String> peekList = new ArrayList<>();

        System.out.println("Print people older than 35");
        personService.getAll().stream()
                .peek(person -> peekList.add(person.getName() + " " + person.getAge()))
                .filter(person -> person.getAge() > 35)
                .map(person -> person.getName() +  " " + person.getAge())
                .forEach(System.out::println);

        System.out.println("Print persons with their ages");
        peekList.forEach(System.out::println);

        System.out.println("Print persons older than 35 using Collector to transform a stream into a list");
        List<Person> personListOlder35 = personService.getAll().stream()
                .filter(person -> person.getAge() > 35)
                .collect(Collectors.toList());
        personListOlder35.forEach(System.out::println);

        System.out.println("Print a list of persons in a Set, overriding equals and hashCode methods of PersonAux to avoid duplicated");
        PersonAux personAux1 = new PersonAux("Joao", 30);
        PersonAux personAux2 = new PersonAux("Felix", 20);
        PersonAux personAux3 = new PersonAux("Joao", 40);
        PersonAux personAux4 = new PersonAux("Anico", 50);
        PersonAux personAux5 = new PersonAux("Joao", 10);

        // ToSet
        Set<PersonAux> personAuxSet = Arrays.asList(personAux1, personAux2, personAux3, personAux4, personAux5).stream()
                .collect(java.util.stream.Collectors.toSet());
        personAuxSet.stream()
                .map(personAux -> personAux.name() + " " + personAux.age())
                .forEach(System.out::println);

        // ToMap
        System.out.println("Print a list of persons in a Map, compounded by name as a key and person object as a value");
        Map<String, PersonAux> personMap = Arrays.asList(personAux1, personAux2, personAux4).stream()
                .collect(Collectors.toMap(PersonAux::name, person -> person));
        personMap.forEach(CollectorsToMapToSetToTreeSet::print);

        // TREESET
        System.out.println("Print a list of persons ordered by using a TreeSet");
        TreeSet treeSet = Arrays.asList(personAux1, personAux2, personAux3, personAux4, personAux5).stream()
                .collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);

    }


    private static void print(String key, PersonAux personMap) {
        System.out.printf("Key: %s, Value: %s %n", key, personMap);
    }

    record PersonAux (String name, Integer age) implements Comparable<PersonAux>{

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonAux personAux = (PersonAux) o;
            return name == personAux.name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(PersonAux personAux) {
            return this.age().compareTo(personAux.age());
        }
    }

}

