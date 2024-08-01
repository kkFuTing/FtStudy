package com.futing.javalib.thread;

/**
 * Created by futing on 2024/7/30.
 */
public class SingletonTest {
    //双重检验锁
//    private static  volatile  SingletonTest INSTANCE;
//    private SingletonTest(){}
//
//    public static SingletonTest getINSTANCE(){
//        if (INSTANCE == null) {
//            synchronized (SingletonTest.class){
//                INSTANCE = new SingletonTest();
//            }
//        }
//
//        return INSTANCE;
//    }
//


    //静态内部类
    private SingletonTest() {
    }

    static class InnerHolder {
        private final static SingletonTest INSTANCE = new SingletonTest();
    }

    public static SingletonTest getInstance() {
        return InnerHolder.INSTANCE;
    }

}

