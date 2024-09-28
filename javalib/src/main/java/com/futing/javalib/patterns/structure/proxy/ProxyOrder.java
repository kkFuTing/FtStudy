package com.futing.javalib.patterns.structure.proxy;


import com.futing.javalib.patterns.service.OrderService;
import com.futing.javalib.patterns.service.impl.OutOrderServiceImpl;

public class ProxyOrder implements OrderService {

    //真实的订单服务
    private OrderService orderService = new OutOrderServiceImpl();

    @Override
    public int saveOrder() {
        System.out.println("开始海外下订单");
        return orderService.saveOrder();
    }
}
