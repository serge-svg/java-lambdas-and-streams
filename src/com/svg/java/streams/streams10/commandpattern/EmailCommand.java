package com.svg.java.streams.streams10.commandpattern;

import com.svg.java.streams.domain.Invoice;

public class EmailCommand implements InvoiceCommand{
    @Override
    public Invoice execute(Invoice invoice) {
        System.out.println("Invoice sent by email: " + invoice.number());
        return invoice;
    }
}
