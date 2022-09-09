package com.svg.java.streams.streams10.commandpattern.withstreams;

import com.svg.java.streams.domain.Invoice;

import java.util.stream.Stream;

/*
    This example reduces then amount of classes by using functional programing, moving
    the functionality of the classes into command manager as functions
 */
public class Main {

    public static void main(String[] args) {
        Invoice computerInvoice = new Invoice(1, "Computer", 1500);
        CommandManager commandManager = new CommandManager();

        System.out.println("Execute all the commands");
        commandManager.save(computerInvoice);
        commandManager.print(computerInvoice);
        commandManager.sendEmail(computerInvoice);

        System.out.println("-------------------------------------------------");
        System.out.println("Execute all the commands using a stream");
        Stream<Invoice> myStream = Stream.of(computerInvoice);
        myStream
                .peek(CommandManager::save)
                .peek(CommandManager::print)
                .peek(CommandManager::sendEmail)
                .forEach(invoice -> System.out.println("Done"));

    }
}
