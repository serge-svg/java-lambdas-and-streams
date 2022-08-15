package com.svg.java.sorting;

import java.util.Comparator;

public class ComparatorSurname implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getSurname().compareTo(person2.getSurname());
    }
}
