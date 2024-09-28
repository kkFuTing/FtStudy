package com.futing.javalib.patterns.create.fatory.fatoryMethod;

import com.futing.javalib.patterns.entity.fruit.Banana;
import com.futing.javalib.patterns.entity.Fruit;

/**
 * 工厂方法模式
 */
public class BananaFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Banana();
    }
}
