package com.futing.javalib.generic.superextend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by futing on 2024/9/12.
 */
public class TestGeneric {

    public static void main(String[] args) {
        List<? extends Fruit> fruits = new ArrayList<>();

        Apple apple = new Apple();
//        fruits.add(apple);//报错拉
//        Fruit fruit = fruits.get(0);
//        Apple appleEx = (Apple) fruits.get(0);

        List<? super Fruit> list = new ArrayList<>();
        list.add(apple);
        Object object = list.get(0);
//        Apple object = list.get(0);//error
        System.out.println(list.get(0));
        System.out.println("测试接口");

        // TODO: 2024/9/12 使用场景

        System.out.println("使用场景=-===");
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());

        ArrayList<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana());
        bananas.add(new Banana());

        System.out.println("=========================打印 printFruits消费场景 apples的=========================");
        printFruits(apples);
        System.out.println("=========================打印 printFruits消费场景 bananas的=========================");
        printFruits(bananas);
        System.out.println("=========================添加不同水果=========================");
        ArrayList<Fruit> fruits1 = new ArrayList<>();
        addFruits(fruits1);

        System.out.println("=========================打印混合水果 =========================");
        printFruits(fruits1);
    }

    //处理消费场景
    public static void addFruits(List<? super Fruit> list) {
        list.add(new Apple());
        list.add(new Banana());

    }

    //处理生产的场景
    public static void printFruits(List<? extends Fruit> list) {
        int index = 0;
        for (Fruit fruit : list) {
            System.out.println(fruit + ":::" + index);
            fruit.show();
        }
    }


}
