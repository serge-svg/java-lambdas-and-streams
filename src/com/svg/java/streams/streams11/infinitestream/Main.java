package com.svg.java.streams.streams11.infinitestream;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> myStream = Stream.iterate(0, i -> i+1);
        Optional<Integer> total =  myStream.limit(3).reduce(Integer::sum);
        if(total.isPresent()) System.out.println(total.get());

    }
}
