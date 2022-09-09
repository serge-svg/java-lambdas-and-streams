package com.svg.java.streams.streams10.commandpattern;

import com.svg.java.streams.domain.Invoice;
/*
    Examples of command pattern
 */
public class Main {

    public static void main(String[] args) {
        // Save, send by email and print an invoice using the command pattern
        Invoice computerInvoice = new Invoice(1, "Computer", 1500);

        InvoiceCommand invoiceCommandSave = new SaveCommand();
        invoiceCommandSave.execute(computerInvoice);

        InvoiceCommand invoiceCommandEmail = new EmailCommand();
        invoiceCommandEmail.execute(computerInvoice);

        InvoiceCommand invoiceCommandPrint = new PrintCommand();
        invoiceCommandPrint.execute(computerInvoice);
        System.out.println("-------------------------------------------------");

        // Let's do it all commands at once on the same invoice
        invoiceCommandPrint.execute(invoiceCommandEmail.execute(invoiceCommandSave.execute(new Invoice(1, "Computer", 1500))));
        System.out.println("-------------------------------------------------");

        // Let's do the same but using a command manager
        CommandManager commandManager = new CommandManager();
        commandManager.add(invoiceCommandSave);
        commandManager.add(invoiceCommandEmail);
        commandManager.add(invoiceCommandPrint);
        commandManager.execute(computerInvoice);

    }
}
