package com.svg.java.streams.domain;


public record Invoice (int number, String concept, double amount) implements Comparable<Invoice>{

    @Override
    public int compareTo(Invoice invoice) {
        return this.amount > invoice.amount ? 1 : this.amount == invoice.amount ? 0 : -1;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "number=" + number +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                '}';
    }


}