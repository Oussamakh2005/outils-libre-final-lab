package com.pricing.service;

public class TaxCalculator {
    private static final double TAX_RATE = 0.10;

    public double computeTax(double taxableAmount) {
        return taxableAmount * TAX_RATE;
    }
}