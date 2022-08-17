package com.svg.java.lambdas.functionalinterfaces.domain;

public record Person(String name, String surname, int age) {

    public boolean isRetired() {
        return this.age() > 65;
    }

    @Override
    public String toString() {
        return "This person is:" + this.name() + " " + this.surname() + " " + this.age();
    }

}