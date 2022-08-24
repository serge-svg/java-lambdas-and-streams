package com.svg.java.lambdas.sorting;

import java.util.Comparator;

public class ComparatorName implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
    }
}
