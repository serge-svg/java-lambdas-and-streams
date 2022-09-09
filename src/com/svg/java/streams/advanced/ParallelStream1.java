package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ParallelStream1 {
    public static void main(String[] args) {
        List<Invoice> invoiceList = new ArrayList<>();
        Invoice invoice;

        for (int i = 0; i < 100; i++) {
            invoice = new Invoice(i, "Concept" + i, Math.round(Math.random() * 1000));
            invoiceList.add(invoice);
        }

        long time1 = System.nanoTime();
        Optional<Double> total = invoiceList.stream().map(Invoice::amount).map(ParallelStream1::duplicate).reduce(Double::sum);
        long time2 = System.nanoTime();
        System.out.println("Time no parallel stream: " + (time2 - time1));

        time1 = System.nanoTime();
        Optional<Double> totalWithParallelStream = invoiceList.parallelStream().map(Invoice::amount).map(ParallelStream1::duplicate).reduce(Double::sum);
        time2 = System.nanoTime();
        System.out.println("Time si parallel stream: " + (time2 - time1));

    }

    static double duplicate(double amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return amount * 2;
    }
}



