package com.futing.opensourelib.designpattern.observer_model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by futing on 2024/8/18.
 */
public class WechatServerObservable implements Observable {
    //容器存储多个 观察者
    private List<Observer> observers = new ArrayList<>();

    private String message;

    @Override
    public void addObServer(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.upadate(message);
        }

    }

    @Override
    public void pushMessage(String message) {
        this.message = message;
        System.out.println("微信观众好发生改变");
        notifyObserver();
    }
}
