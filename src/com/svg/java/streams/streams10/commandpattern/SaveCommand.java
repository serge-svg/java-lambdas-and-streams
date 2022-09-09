package com.svg.java.streams.streams10.commandpattern;

import com.svg.java.streams.domain.Invoice;

public class SaveCommand implements InvoiceCommand{
    @Override
    public Invoice execute(Invoice invoice) {
        System.out.println("Saved invoice: " + invoice.number());
        return invoice;
    }
}
