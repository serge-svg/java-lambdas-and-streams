package com.svg.java.streams.streams10.commandpattern.withparallelstreams;

import com.svg.java.streams.domain.Invoice;

/*
    Class able to execute actions
 */
public class CommandManager {

    public static Invoice save(Invoice invoice) {
        try {
            Thread.sleep(1000);
            System.out.println("Saved invoice: " + invoice.number());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public static Invoice print(Invoice invoice) {
        try {
            Thread.sleep(1000);
            System.out.println(invoice);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public static Invoice sendEmail(Invoice invoice) {
        try {
            Thread.sleep(1000);
            System.out.println("Invoice sent by email: " + invoice.number());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return invoice;
    }

}
