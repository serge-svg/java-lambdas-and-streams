package com.svg.java.streams.streams9.io;

import java.util.stream.Stream;
/*
    This example creates a list of even numbers up to a set limit
 */
public class StreamBuilder {
    public static void main(String[] args) {
        Stream<Integer> myStream = streamNumbers(10);
        myStream.forEach(System.out::println);
    }

    private static Stream<Integer> streamNumbers(int top) {
        Stream.Builder<Integer> builder = Stream.builder();
        for (int i = 0; i < top; i++) {
            if (i % 2 == 0) builder.add(i);
        }

        return builder.build();
    }
}
