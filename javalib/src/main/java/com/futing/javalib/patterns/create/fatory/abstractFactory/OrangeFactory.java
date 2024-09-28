package com.futing.javalib.patterns.create.fatory.abstractFactory;

import com.futing.javalib.patterns.entity.Bag;
import com.futing.javalib.patterns.entity.Fruit;
import com.futing.javalib.patterns.entity.bag.OrangeBag;
import com.futing.javalib.patterns.entity.fruit.Orange;

/**
 * 水果工厂
 */
public class OrangeFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Orange("Peter",50);
    }

    @Override
    public Bag getBag() {
        return new OrangeBag();
    }
}
