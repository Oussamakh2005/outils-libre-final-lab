package com.pricing;

import java.util.*;


public class BadPricingEngine {
    public static double calculate(double[] prices, int[] qtys, String custType, String discCode) {
        double sub = 0;
        for (int i = 0; i < prices.length; i++) {
            sub = sub + prices[i] * qtys[i];
        }
        double d = 0;
        if (discCode.equals("SAVE10")) d = 0.1;
        else if (discCode.equals("SAVE20")) d = 0.2;
        if (custType.equals("VIP")) d = d + 0.05;
        double discAmt = sub * d;
        double tax = (sub - discAmt) * 0.1;
        double fin = sub - discAmt + tax;
        return fin;
    }
}