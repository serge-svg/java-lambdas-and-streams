package com.svg.java.lambdas.methodsreference;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("name1", "bbb", 20));
        personList.add(new Person("name2", "aaa", 30));
        personList.add(new Person("name3", "ccc", 10));
        personList.add(new Person("name4", "ddd", 66));

        List<Person> list = searchPersonByFilter((p)-> p.age() < 30, personList);
        printList(list, "");

        // Example of reference method, it is like a lambda but inside a class
        list = searchPersonByFilter(Person::isRetired, personList);
        printList(list, "isRetired");
        list = searchPersonByFilter(Person::isAbleToWork, personList);
        printList(list, "isAbleToWork");
    }

    private static List<Person> searchPersonByFilter(PersonFilter personFilter, List<Person> personList) {
        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (personFilter.test(person)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    private static void printList(List<Person> personList, String message) {
        for (Person person : personList) {
            System.out.printf("Person: %s %s %s %s %n", person.name(), person.surname(), person.age(), message);
        }
    }

    record Person(String name, String surname, Integer age) {

        public static boolean isRetired(Person person) {
            return person.age() > 65;
        }
        /* Example using this with non-static method
        public boolean isRetired() {
            return this.age() > 65;
        }
        */

        public static boolean isAbleToWork(Person person) {
            return person.age() > 18 && person.age() < 66;
        }

    }

    interface PersonFilter {
        boolean test(Person person);
    }


}
