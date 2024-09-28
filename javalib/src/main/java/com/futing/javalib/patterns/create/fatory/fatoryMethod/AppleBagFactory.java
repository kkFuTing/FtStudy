package com.futing.javalib.patterns.create.fatory.fatoryMethod;

import com.futing.javalib.patterns.entity.Bag;
import com.futing.javalib.patterns.entity.bag.AppleBag;

/**
 * 工厂方法模式
 */
public class AppleBagFactory implements BagFactory{
    public Bag getBag(){
        return new AppleBag();
    }
}
