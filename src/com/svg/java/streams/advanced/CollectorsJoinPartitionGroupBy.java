package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Person;
import com.svg.java.streams.services.PersonService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsJoinPartitionGroupBy {

    public static void main(String[] args) {

        // Join - Transform the names of the list to a String split by ','
        String namesToJoin = new PersonService().getAll().stream()
                .map(personAux -> personAux.getName())
                .collect(Collectors.joining(","));
        System.out.println(namesToJoin);

        // Partition - Create two maps with retired persons and none retired
        Map<Boolean, List<Person>> booleanListMap = new PersonService().getAll().stream()
                .collect(Collectors.partitioningBy(Person::isRetired));
        System.out.println("Persons retired");
        booleanListMap.get(true).forEach(System.out::println);
        System.out.println("Persons not retired");
        booleanListMap.get(false).forEach(System.out::println);

        // Partition - Create two maps of persons with age pair and odd
        Map<Boolean, List<Person>> booleanListMap2 = new PersonService().getAll().stream()
                .collect(Collectors.partitioningBy(person -> person.getAge()%2==0));
        System.out.println("Persons with age pair");
        booleanListMap2.get(true).forEach(System.out::println);
        System.out.println("Persons with age odd");
        booleanListMap2.get(false).forEach(System.out::println);

        // GroupBy - Group up persons by their age
        List<Person> personList = new PersonService().getAll();
        System.out.println("Print list of persons and their ages");
        personList.stream()
                .map(person -> person.getName() + ", " +person.getAge())
                .forEach(System.out::println);
        System.out.println("Print list of persons grouped by ages");
        Map<Integer, List<Person>> groupedMap = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getAge()));
        groupedMap.values().forEach(System.out::println);
    }
}
