package com.svg.java.lambdas.functionalinterfaces.supplier;

import com.svg.java.lambdas.domain.Person;

public class ServiceSignature {

    Person person;

    public ServiceSignature(Person person){
        this.person = person;
    }

    public String getSignatureForPerson(){
        return "Signature of person: " + person.getName() + " " +person.getSurname();
    }

}
