package com.pricing;

import com.pricing.enums.CustomerType;
import com.pricing.model.LineItem;
import com.pricing.model.Order;
import com.pricing.service.PricingService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PricingServiceTest {
    private final PricingService service = new PricingService();

    @Test
    void testRegularNoDiscount() {
        Order order = new Order(List.of(new LineItem(10,2), new LineItem(20,1)), CustomerType.REGULAR, "");
        PricingService.PricingResult result = service.calculateFinalPrice(order);
        assertEquals(40.0, result.subtotal);
        assertEquals(0.0, result.discount);
        assertEquals(4.0, result.tax);
        assertEquals(44.0, result.finalPrice);
    }

    @Test
    void testVipWithSave10() {
        Order order = new Order(List.of(new LineItem(100,1)), CustomerType.VIP, "SAVE10");
        PricingService.PricingResult result = service.calculateFinalPrice(order);
        assertEquals(100.0, result.subtotal);
        assertEquals(15.0, result.discount);
        assertEquals(8.5, result.tax);
        assertEquals(93.5, result.finalPrice);
    }

    @Test
    void testUnknownDiscountCode() {
        Order order = new Order(List.of(new LineItem(50,2)), CustomerType.REGULAR, "UNKNOWN");
        PricingService.PricingResult result = service.calculateFinalPrice(order);
        assertEquals(100.0, result.subtotal);
        assertEquals(0.0, result.discount);
        assertEquals(10.0, result.tax);
        assertEquals(110.0, result.finalPrice);
    }
}
