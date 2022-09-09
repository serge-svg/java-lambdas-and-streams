package com.svg.java.streams.streams10.commandpattern;

import com.svg.java.streams.domain.Invoice;

public interface InvoiceCommand {
    public Invoice execute(Invoice invoice);
}
