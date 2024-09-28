package com.futing.javalib.patterns.entity;


import com.futing.javalib.patterns.action.visit.Visit;

/**
 * 水果接口
 */
public interface Fruit {

    int price();

    void draw();

    int accept(Visit visit);

}
