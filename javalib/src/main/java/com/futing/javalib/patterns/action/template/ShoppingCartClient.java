package com.futing.javalib.patterns.action.template;


import com.futing.javalib.patterns.action.strategy.Discount;
import com.futing.javalib.patterns.action.strategy.FullDiscount;
import com.futing.javalib.patterns.action.strategy.NewerDiscount;
import com.futing.javalib.patterns.action.strategy.SecondDiscount;
import com.futing.javalib.patterns.create.fatory.simple.StaticFactory;
import com.futing.javalib.patterns.entity.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板方法模式
 * 订单费用结算过程
 */
public class ShoppingCartClient {

    private static Map<String, Discount> disCounts = new HashMap();
    static {
        disCounts.put("full",new FullDiscount());
        disCounts.put("newer",new NewerDiscount());
        disCounts.put("second",new SecondDiscount());
    }

    public static void main(String[] args) {
        List<Fruit> products = new ArrayList();

        products.add(StaticFactory.getFruitApple());
        products.add(StaticFactory.getFruitBanana());
        products.add(StaticFactory.getFruitOrange());

        ShoppingCart cart = new OtherPayShopping(products);

        //注入优惠方案  (策略方案)
        String discount = "second";
        cart.setDiscount(disCounts.get(discount));

        cart.submitOrder();
    }


}
