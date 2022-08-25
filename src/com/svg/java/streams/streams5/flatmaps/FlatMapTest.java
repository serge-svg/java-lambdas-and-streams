package com.svg.java.streams.streams5.flatmaps;

import com.svg.java.streams.domain.Language;
import com.svg.java.streams.services.PersonService;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FlatMapTest {

    @Test
    public void flatMapLanguages(){
        PersonService personService = new PersonService();

        Set<Language> asiaticLanguages = new HashSet<Language>();
        asiaticLanguages.add(Language.Cantonese);
        asiaticLanguages.add(Language.Mandarin);

        Set<Language> latinLanguages = new HashSet<Language>();
        latinLanguages.add(Language.French);
        latinLanguages.add(Language.Catalan);
        latinLanguages.add(Language.Spanish);

        Student student1 = new Student(personService.getPersonByName("name1").get(0), asiaticLanguages);
        System.out.println(student1);
        Student student2 = new Student(personService.getPersonByName("name1").get(0), latinLanguages);
        System.out.println(student2);

    }
}
