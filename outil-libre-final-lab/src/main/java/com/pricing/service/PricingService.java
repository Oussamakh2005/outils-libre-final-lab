package com.pricing.service;

import com.pricing.model.Order;

public class PricingService {
    private final DiscountCalculator discountCalculator;
    private final TaxCalculator taxCalculator;

    public PricingService() {
        this.discountCalculator = new DiscountCalculator();
        this.taxCalculator = new TaxCalculator();
    }

    public PricingResult calculateFinalPrice(Order order) {
        double subtotal = order.computeSubtotal();
        double discount = discountCalculator.computeDiscount(subtotal, order.getCustomerType(), order.getDiscountCode());
        double taxable = subtotal - discount;
        double tax = taxCalculator.computeTax(taxable);
        double finalPrice = taxable + tax;

        return new PricingResult(subtotal, discount, tax, finalPrice);
    }

    public static class PricingResult {
        public final double subtotal;
        public final double discount;
        public final double tax;
        public final double finalPrice;

        public PricingResult(double subtotal, double discount, double tax, double finalPrice) {
            this.subtotal = subtotal;
            this.discount = discount;
            this.tax = tax;
            this.finalPrice = finalPrice;
        }
    }
}