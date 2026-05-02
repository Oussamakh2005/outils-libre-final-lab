package com.pricing.model;

import com.pricing.enums.CustomerType;
import java.util.*;

public class Order {
    private final List<LineItem> items;
    private final CustomerType customerType;
    private final String discountCode;

    public Order(List<LineItem> items, CustomerType customerType, String discountCode) {
        this.items = Collections.unmodifiableList(items);
        this.customerType = customerType;
        this.discountCode = discountCode;
    }

    public List<LineItem> getItems() { return items; }
    public CustomerType getCustomerType() { return customerType; }
    public String getDiscountCode() { return discountCode; }

    public double computeSubtotal() {
        return items.stream().mapToDouble(LineItem::getTotal).sum();
    }
}