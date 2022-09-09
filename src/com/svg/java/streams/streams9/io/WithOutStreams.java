package com.svg.java.streams.streams9.io;

import java.io.File;

/*
 Create a program able to print all directories and file names inside ./src
 */
public class WithOutStreams {

    public static void main(String[] args) {
        File file = new File("./src");
        File[] files = file.listFiles();
        for (File f : files) {
            print(f);
        }

    }

    private static void print(File f) {
        if (f.isDirectory()) {
            for(File d : f.listFiles()) {
                System.out.println(d.getName());
                print(d);
            }
        } else {
            System.out.println(f.getName());
        }

    }
}
