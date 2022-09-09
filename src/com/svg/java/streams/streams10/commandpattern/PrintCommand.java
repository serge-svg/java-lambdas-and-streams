package com.svg.java.streams.streams10.commandpattern;

import com.svg.java.streams.domain.Invoice;

/*
    Create a structure of classes and interfaces to print bill's attributes
    Use a Command manager
 */
public class PrintCommand implements InvoiceCommand {

    @Override
    public Invoice execute(Invoice invoice) {
        System.out.println(invoice);
        return invoice;
    }
}
