package com.svg.java.streams.streams9.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WithStreams {

    public static void main(String[] args) {

        try {
            // Print filenames and their routes
            Stream<Path> myStream1 = Files.walk(Paths.get("./src"));
            myStream1.forEach(System.out::println);

            // Print filenames and without their routes
            Stream<Path> myStream2 = Files.walk(Paths.get("./src"));
            myStream2.map(Path::toFile)
                    .filter(File::isFile)
                    .map(File::getName)
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
