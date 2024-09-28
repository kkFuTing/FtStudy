package com.futing.javalib.generic.chachu;

/**
 * Created by futing on 2024/9/12.
 */
public class Apple extends Fruit<String> {
    @Override
    public void showFruitName(String name) {
        super.showFruitName(name);
        System.out.println("Apple:::" + name);

    }
}
