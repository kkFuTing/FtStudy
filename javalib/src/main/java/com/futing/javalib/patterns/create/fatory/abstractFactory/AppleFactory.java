package com.futing.javalib.patterns.create.fatory.abstractFactory;

import com.futing.javalib.patterns.entity.Bag;
import com.futing.javalib.patterns.entity.Fruit;
import com.futing.javalib.patterns.entity.bag.AppleBag;
import com.futing.javalib.patterns.entity.fruit.Apple;

/**
 * 水果工厂
 */
public class AppleFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Apple();
    }

    @Override
    public Bag getBag() {
        return new AppleBag();
    }
}
