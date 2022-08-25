package com.svg.java.streams.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Person {

    private final String name;
    private final String surname;
    private final int age;
    private List<Sport> sportList;

    public Person(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.age = person.getAge();
        this.sportList =  new ArrayList<>();
    }

    public void addSport(Sport sport) {
        this.sportList.add(sport);
    }
    public List<Sport> getSports() {
        return this.sportList;
    }
    public boolean isRetired() {
        return this.age > 65;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName()
                + " Surname: " + this.getSurname()
                + " Age: " + this.getAge()
                + " Sports :" + this.sportList;
    }

}