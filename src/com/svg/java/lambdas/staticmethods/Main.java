package com.svg.java.lambdas.staticmethods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("name1", "ccc", 31));
        personList.add(new Person("name2", "aaa", 22));
        personList.add(new Person("name3", "bbb", 33));
        personList.add(new Person("name4", "ddd", 66));

        PersonFilter personFilterByName_name2 = new PersonFilterByName("name2");
        Predicate<Person> personFilterRetired = Person::isRetired;
        List<Person> list = searchPersonByFilter(PersonFilter.orMultiple(personFilterByName_name2, personFilterRetired), personList);
        printList(list);
    }

    public static List<Person> searchPersonByFilter(Predicate personFilter, List<Person> personList) {
        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (personFilter.test(person)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    private static void printList(List<Person> personList) {
        for (Person person : personList) {
            System.out.printf("Person: %s %s %s %n", person.getName(), person.getSurname(), person.getAge());
        }
    }

}
