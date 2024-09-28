package com.futing.javalib.memory.myleakcanary;

// TODO: 2024/9/3

/**
 * 原理：写的
 *
 *
 */


public class leakcanaryTest {

    public static void main(String[] args) {

        Watcher watcher = new Watcher();

        Object obj = new Object();
        System.out.println("obj: " + obj);
        watcher.watch(obj, "");
        Utils.sleep(500);
        //释放对象
        obj = null;
        Utils.gc();

        Utils.sleep(6000);
        System.out.println("查看是否在怀疑列表：" + watcher.getRetainedReferences().size());
    }

}
