package com.svg.java.streams.advanced;

import com.svg.java.streams.domain.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;


public class ParallelStream2 {
    public static void main(String[] args) {
        List<Invoice> invoiceList = new ArrayList<>();
        Invoice invoice;

        for (int i = 0; i < 10; i++) {
            invoice = new Invoice(i, "Concept" + i, Math.round(Math.random() * 10000));
            invoiceList.add(invoice);
        }
        long time1 = System.currentTimeMillis();
        ForkJoinPool tp = new ForkJoinPool(4);
        Optional<Double> total = null;
        try {
            total = tp.submit(()->{
                        return invoiceList.parallelStream().map(Invoice::amount).map(ParallelStream2::duplicate).reduce(Double::sum);
                    }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (total.isPresent())
            System.out.println("Time parallel stream: " + total.get());

        long time2 = System.currentTimeMillis();

        System.out.println("Time parallel stream: " + (time2 - time1));

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



