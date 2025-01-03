package com.futing.javalib.patterns.entity.fruit;

import com.futing.javalib.patterns.action.visit.Visit;
import com.futing.javalib.patterns.entity.Fruit;
import com.futing.javalib.patterns.entity.bag.OrangeBag;

/**
 * 桔子
 * Created by Peter on 10/9 009.
 */
public class Orange implements Fruit {
    private String name = "";
    private int price = 70;

    public Orange(String name,int price){
        this.price = price;
        this.name = name;
    }

    public void pack(OrangeBag bag){
        bag.pack();
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public void draw() {
        System.out.print("砂糖桔");
    }

    public int accept(Visit visit){
        return visit.sell(this);
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
