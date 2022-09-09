package com.svg.java.streams.streams9.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamFile {
/*
    Read the file text.txt and print its lines
 */
    public static void main(String[] args) {
        Pattern splitPattern = Pattern.compile(",");
        Pattern splitPatternNumber = Pattern.compile("[0-9]+");
        try {
            System.out.println("Print lines");
            Stream<String> myStream1 = Files.lines(Paths.get("./src/com/svg/java/text.txt"));
            myStream1.forEach(System.out::println);

            System.out.println("Print values splitted by ','");
            Stream<String> myStream2 = Files.lines(Paths.get("./src/com/svg/java/text.txt"));
            myStream2
                    .flatMap(s -> splitPattern.splitAsStream(s))
                    .forEach(System.out::println);

            System.out.println("Print the numbers");
            Stream<String> myStream3 = Files.lines(Paths.get("./src/com/svg/java/text.txt"));
            myStream3
                    .flatMap(s -> splitPattern.splitAsStream(s))
                    .filter(splitPatternNumber.asPredicate())
                    .forEach(System.out::println);

            System.out.println("Print the total sum of the numbers");
            Stream<String> myStream4 = Files.lines(Paths.get("./src/com/svg/java/text.txt"));
            myStream4
                    .flatMap(s -> splitPattern.splitAsStream(s))
                    .filter(splitPatternNumber.asPredicate())
                    .map(Integer::parseInt)
                    .reduce(Integer::sum)
                    .ifPresent(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
