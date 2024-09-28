package com.futing.javalib.patterns.create.fatory.abstractFactory;

import com.futing.javalib.patterns.entity.Bag;
import com.futing.javalib.patterns.entity.Fruit;
import com.futing.javalib.patterns.entity.bag.BananaBag;
import com.futing.javalib.patterns.entity.fruit.Banana;

/**
 * 水果工厂
 */
public class BananaFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Banana();
    }

    @Override
    public Bag getBag() {
        return new BananaBag();
    }
}
