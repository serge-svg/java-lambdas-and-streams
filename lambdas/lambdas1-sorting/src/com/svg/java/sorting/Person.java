package com.svg.java.sorting;

public class Person implements Comparable<Person>{
    private final String name;

    private final String surname;

    private final Integer age;
    public Person(String name, String surnames, int age) {
        this.name = name;
        this.surname = surnames;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        return this.getAge().compareTo(person.getAge());
    }

}
