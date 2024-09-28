package com.futing.javalib.patterns.create.fatory.fatoryMethod;

import com.futing.javalib.patterns.entity.fruit.Apple;
import com.futing.javalib.patterns.entity.Fruit;

/**
 * 工厂方法模式
 */
public class AppleFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Apple();
    }
}
