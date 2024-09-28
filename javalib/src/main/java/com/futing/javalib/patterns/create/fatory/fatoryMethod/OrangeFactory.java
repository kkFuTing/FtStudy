package com.futing.javalib.patterns.create.fatory.fatoryMethod;

import com.futing.javalib.patterns.entity.Fruit;
import com.futing.javalib.patterns.entity.fruit.Orange;

/**
 * 工厂方法模式
 */
public class OrangeFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Orange("Peter",80);
    }
}
