package com.futing.opensourelib.designpattern.observer_model;

/**
 * Created by futing on 2024/8/18.
 */
public class UserPerson implements Observer {

    private String name;
    private String message;


    public UserPerson(String name) {
        this.name = name;
    }

    @Override
    public void upadate(Object object) {
        this.message = (String) object;
        System.out.println(name + "::收到消息【" + message + "】");

    }
}
