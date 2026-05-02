package com.pricing.model;

public class LineItem {
    private final double price;
    private final int quantity;

    public LineItem(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() { return price * quantity; }
}