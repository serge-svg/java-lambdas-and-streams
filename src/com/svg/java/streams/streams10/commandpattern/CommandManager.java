package com.svg.java.streams.streams10.commandpattern;

import com.svg.java.streams.domain.Invoice;

import java.util.ArrayList;
import java.util.List;

/*
    Class able to execute a list of commands
 */
public class CommandManager implements InvoiceCommand{

    List<InvoiceCommand> invoiceCommandList = new ArrayList<>();

    public void add(InvoiceCommand invoiceCommand){
        invoiceCommandList.add(invoiceCommand);
    }

    @Override
    public Invoice execute(Invoice invoice) {
//        for (InvoiceCommand invoiceCommand : invoiceCommandList){
//            invoiceCommand.execute(invoice);
//        }
        invoiceCommandList.stream().forEach(invoiceCommand -> invoiceCommand.execute(invoice));
        return invoice;
    }
}
