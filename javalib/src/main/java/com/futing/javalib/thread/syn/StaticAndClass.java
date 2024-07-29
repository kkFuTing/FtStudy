package com.futing.javalib.thread.syn;

/**
 * Created by futing on 2024/3/30.
 */
public class StaticAndClass {
    private static Object object = new Object();


    private static void synStatic() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName());

        }
    }

    public static void main(String[] args) {
        StaticAndClass staticAndClass = new StaticAndClass();
        staticAndClass.synStatic();
    }
}
