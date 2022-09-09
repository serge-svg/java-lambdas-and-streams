package com.svg.java.streams.streams10.commandpattern.withparallelstreams;

import com.svg.java.streams.domain.Invoice;
import com.svg.java.streams.streams10.commandpattern.withstreams.CommandManager;

import java.util.stream.Stream;

/*
    This example reduces then amount of classes by using functional programing, moving
    the functionality of the classes into command manager as functions
 */
public class Main {

    public static void main(String[] args) {
        Invoice computerInvoice1 = new Invoice(1, "Computer1", 1100);
        Invoice computerInvoice2 = new Invoice(2, "Computer2", 1200);
        Invoice computerInvoice3 = new Invoice(3, "Computer3", 1300);
        System.out.println("---------------------------------------");

        Stream<Invoice> myStream1 = Stream.of(computerInvoice1, computerInvoice2, computerInvoice3);
        long t1 = System.currentTimeMillis();
        myStream1
                .peek(CommandManager::save)
                .peek(CommandManager::print)
                .peek(CommandManager::sendEmail)
                .forEach(invoice -> System.out.println("Done"));
        long t2 = System.currentTimeMillis();

        System.out.println("The execution without parallel stream has last: " + (t2 - t1));
        System.out.println("---------------------------------------");

        System.out.println("Execute all the commands using a stream");
        Stream<Invoice> myStream2 = Stream.of(computerInvoice1, computerInvoice2, computerInvoice3);
        t1 = System.currentTimeMillis();
        myStream2
                .parallel()
                .peek(CommandManager::save)
                .peek(CommandManager::print)
                .peek(CommandManager::sendEmail)
                .forEach(invoice -> System.out.println("Done"));
        t2 = System.currentTimeMillis();
        System.out.println("This execution with parallel stream  has last: " + (t2 - t1));

    }


}
