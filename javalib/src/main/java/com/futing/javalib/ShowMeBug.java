package com.futing.javalib;/*
 可以引⼊的库和版本相关请参考 “环境说明”
 请勿更改 `ShowMeBug` 类名以防执⾏失败

 Please refer to the "Environmental Notes" for the libraries and versions that can be introduced.
 Don't modify the `ShowMeBug` class to prevent execution failure
*/


import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class ShowMeBug {
    private ConcurrentHashMap<String, Order> orders;

    public ShowMeBug() {
        this.orders = new ConcurrentHashMap<>();
    }
    private static class Order {
        private String orderID;
        private LocalDateTime time;
        private double amount;

        public Order(String orderID, LocalDateTime time, double amount) {
            this.orderID = orderID;
            this.time = time;
            this.amount = amount;
        }

        public String getOrderID() {
            return orderID;
        }

        public LocalDateTime getTime() {
            return time;
        }

        public double getAmount() {
            return amount;
        }
    }
    /**
     * 接收并储存新订单
     *
     * @param orderID 唯一标识一个订单的字符串
     * @param time    下单时间
     * @param amount  订单金额
     */
    public void addOrder(String orderID, LocalDateTime time, double amount) {
        if (amount < 0) {
            return;
        }

        synchronized (orders) {
            if (orders.containsKey(orderID)) {
                // 订单编号重复的处理，这里假设报错或者忽略重复订单
                System.err.println("Error: Order ID " + orderID + " already exists.");
                return;
            }
            Order order = new Order(orderID, time, amount);
            orders.put(orderID, order);
            orders.putIfAbsent(orderID, order);
        }
    }

    /**
     * 返回指定时间段内的订单总金额（包含 start 和 end）
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 订单总金额
     */
    public double getAmount(LocalDateTime start, LocalDateTime end) {
        double totalAmount = 0.0;
//        synchronized (orders) {
            for (Order order : orders.values()) {
                LocalDateTime orderTime = order.getTime();
                if (orderTime.isEqual(start) || orderTime.isEqual(end) ||
                        (orderTime.isAfter(start) && orderTime.isBefore(end))) {
                    totalAmount += order.getAmount();
                }
            }
//        }
        return totalAmount;
    }
}

