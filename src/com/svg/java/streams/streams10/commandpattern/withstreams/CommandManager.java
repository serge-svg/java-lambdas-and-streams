package com.svg.java.streams.streams10.commandpattern.withstreams;

import com.svg.java.streams.domain.Invoice;

/*
    Class able to execute actions
 */
public class CommandManager {

    public static Invoice save(Invoice invoice) {
        System.out.println("Saved invoice: " + invoice.number());
        return invoice;
    }

    public static Invoice print(Invoice invoice) {
        System.out.println(invoice);
        return invoice;
    }

    public static Invoice sendEmail(Invoice invoice) {
        System.out.println("Invoice sent by email: " + invoice.number());
        return invoice;
    }

}
