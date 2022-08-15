package com.svg.java.defaultmethods;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("name1", "ccc", 31));
        personList.add(new Person("name2", "aaa", 22));
        personList.add(new Person("name3", "bbb", 33));
        personList.add(new Person("name4", "ddd", 66));

        PersonFilter personFilterByName_name2 = new PersonFilterByName("name2");
        PersonFilter personFilterByName_name2_Or_Surname_bbb = personFilterByName_name2.or(new PersonFilterBySurname("bbb"));
        List<Person> list = searchPersonByFilter(personFilterByName_name2_Or_Surname_bbb, personList);
        printList(list);

        PersonFilter personFilterByName_name2_Or_Surname_bbb_Or_isRetired = personFilterByName_name2_Or_Surname_bbb.or(Person::isRetired);
        list = searchPersonByFilter(personFilterByName_name2_Or_Surname_bbb_Or_isRetired, personList);
        printList(list);

    }

    public static List<Person> searchPersonByName(String name, List<Person> personList) {
        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().contentEquals(name)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    public static List<Person> searchPersonBySurname(String surname, List<Person> personList) {
        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getSurname().contentEquals(surname)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    public static List<Person> searchPersonByFilter(PersonFilter personFilter, List<Person> personList) {
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
