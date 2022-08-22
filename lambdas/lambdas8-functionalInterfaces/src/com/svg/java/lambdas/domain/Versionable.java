package com.svg.java.lambdas.domain;

public interface Versionable<T extends Versionable<T>> {

    int version();

    static <T extends Versionable<T>> T isHigherVersion(T current, T next) {
        return current.version() > next.version() ? current : next;
    }

    default T isHigher(T t) {
        return this.version() > t.version() ? (T)this : t;
    }

}
