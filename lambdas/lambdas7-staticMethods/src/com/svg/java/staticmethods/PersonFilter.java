package com.svg.java.staticmethods;

import java.util.function.Predicate;

public interface PersonFilter extends Predicate<Person> {
    static Predicate<Person> orMultiple(Predicate<Person> ...predicates){
        Predicate<Person> mergePredicates = predicates[0];
        for (Predicate<Person> predicate : predicates) {
            mergePredicates = mergePredicates.or(predicate);
        }
        return mergePredicates;
    }

    /*
    boolean test(T value);
    // Adding a OR clause on the active filter
    default PersonFilter<T> or (PersonFilter<T> filter) {
        return (T t)->(test(t) || filter.test(t));
    }
    */

}
