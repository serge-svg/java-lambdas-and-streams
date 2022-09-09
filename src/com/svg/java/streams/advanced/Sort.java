package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Invoice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    public static void main(String[] args) {
        List<Invoice> invoiceList = new ArrayList<>();
        Invoice invoice;

        for (int i = 0; i < 1000; i++) {
            invoice = new Invoice(i, "Concept" + i, Math.round(Math.random() * 1000));
            invoiceList.add(invoice);
        }

        long time1 = System.nanoTime();
        invoiceList.stream().sorted().map(Invoice::amount).collect(Collectors.toList());
        long time2 = System.nanoTime();
        System.out.println(time2 - time1);

        time1 = System.nanoTime();
        invoiceList.stream().map(Invoice::amount).collect(Collectors.toList());
        time2 = System.nanoTime();
        System.out.println(time2 - time1);

        System.out.println("Sorted by concept");
        invoiceList.stream().limit(10).sorted(Comparator.comparing(Invoice::concept)).forEach(System.out::println);

    }

}

