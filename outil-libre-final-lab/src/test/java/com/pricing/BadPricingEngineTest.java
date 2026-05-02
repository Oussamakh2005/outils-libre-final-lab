package com.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BadPricingEngineTest {
    @Test
    void testRegularNoDiscount() {
        double[] prices = {10.0, 20.0};
        int[] qtys = {2, 1};
        double result = BadPricingEngine.calculate(prices, qtys, "REGULAR", "");
        // subtotal = 10*2 + 20*1 = 40, discount 0, tax 4, final = 44
        assertEquals(44.0, result, 0.001);
    }

    @Test
    void testVipWithSave10() {
        double[] prices = {100.0};
        int[] qtys = {1};
        double result = BadPricingEngine.calculate(prices, qtys, "VIP", "SAVE10");
        // subtotal 100, discount 10%+5%=15% => 15, taxable 85, tax 8.5, final 93.5
        assertEquals(93.5, result, 0.001);
    }
}