package com.pricing.service;

import com.pricing.enums.CustomerType;
import java.util.Map;

public class DiscountCalculator {
    private static final Map<String, Double> DISCOUNT_MAP = Map.of(
            "SAVE10", 0.10,
            "SAVE20", 0.20
    );
    private static final double VIP_EXTRA = 0.05;

    public double calculateDiscountRate(CustomerType customerType, String discountCode) {
        double base = DISCOUNT_MAP.getOrDefault(discountCode, 0.0);
        if (customerType == CustomerType.VIP) {
            base += VIP_EXTRA;
        }
        return Math.min(base, 0.30); // cap at 30%
    }

    public double computeDiscount(double subtotal, CustomerType customerType, String discountCode) {
        double rate = calculateDiscountRate(customerType, discountCode);
        return subtotal * rate;
    }
}