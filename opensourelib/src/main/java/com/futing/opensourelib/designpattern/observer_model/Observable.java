package com.futing.opensourelib.designpattern.observer_model;

/**
 * Created by futing on 2024/8/18.
 */

//被观察者
public interface Observable {
    //关注
    void addObServer(Observer observer);

    //取消关注
    void removeObserver(Observer observer);

    //被观察发生发生了改变
    void notifyObserver();

    //微信公众号的服务 编辑部门 发布一条消息
    void pushMessage(String message);

}
