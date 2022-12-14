package com.svg.java.lambdas.genericinterface;

public interface Filter<T> {

    boolean test(T value);
    // Adding a OR clause on the active filter
    default Filter<T> or (Filter<T> filter) {
        return (T t)->(test(t) || filter.test(t));
    }

}
