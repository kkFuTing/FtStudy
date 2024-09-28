package com.futing.javalib.patterns.create.fatory.abstractFactory;

import com.futing.javalib.patterns.entity.Bag;
import com.futing.javalib.patterns.entity.Fruit;

/**
 * 抽象水果工厂
 */
public abstract class AbstractFactory {

    public abstract  Fruit getFruit();

    public abstract Bag getBag();

}
