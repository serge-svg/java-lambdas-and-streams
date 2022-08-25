package com.svg.java.streams.streams5.flatmaps;

import com.svg.java.streams.domain.Language;
import com.svg.java.streams.domain.Person;

import java.util.Set;

public class Student extends Person {
    private Set<Language> languages;

    public Student(Person person, Set<Language> languages) {
        super(person);
        this.languages = languages;
    }

    public void addLanguage(Language language) {
        languages.add(language);
    }

    public Set<Language> getLanguages(){
        return languages;
    }

    @Override
    public String toString() {
        return "Student{" + super.getName() +
               " languages=" + languages +
                '}';
    }


}
