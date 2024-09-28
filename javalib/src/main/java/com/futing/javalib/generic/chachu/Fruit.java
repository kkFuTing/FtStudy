package com.futing.javalib.generic.chachu;

/**
 * Created by futing on 2024/9/12.
 */
public class Fruit<T> {

    public void showFruitName(T name) {
        System.out.println("Fruit:::"+name);
    }
}
