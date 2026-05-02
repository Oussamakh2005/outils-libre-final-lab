package com.pricing;

import com.pricing.enums.CustomerType;
import com.pricing.model.LineItem;
import com.pricing.model.Order;
import com.pricing.service.PricingService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage
        List<LineItem> items = List.of(new LineItem(100, 1));
        Order order = new Order(items, CustomerType.VIP, "SAVE10");
        PricingService service = new PricingService();
        PricingService.PricingResult result = service.calculateFinalPrice(order);

        System.out.println("Subtotal: " + result.subtotal);
        System.out.println("Discount: " + result.discount);
        System.out.println("Tax: " + result.tax);
        System.out.println("Final: " + result.finalPrice);
    }
}