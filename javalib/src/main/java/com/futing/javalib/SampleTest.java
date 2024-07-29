package com.futing.javalib;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Created by futing on 2024/7/2.
 */
public class SampleTest {

    public static void main(String[] args) {
        ShowMeBug orderSystem = new ShowMeBug();
        LocalDateTime now = LocalDateTime.now();

        for (int i = 0; i < 100; i++) {
            orderSystem.addOrder("order" + i, now.plusHours(i), i);
        }
        double totalAmount = orderSystem.getAmount(now, now.plusHours(99));
        System.out.println(totalAmount);
    }

}
