package com.futing.javalib.patterns.create.fatory.fatoryMethod;

import com.futing.javalib.patterns.entity.Bag;
import com.futing.javalib.patterns.entity.bag.BananaBag;

/**
 * 工厂方法模式
 */
public class BananaBagFactory implements BagFactory{
    public Bag getBag(){
        return new BananaBag();
    }
}
