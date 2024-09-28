package com.example.kotlinlib.bsase.java;

// TODO　Java 单例模式1
public class NetManager {

    static class Holder {

        private static NetManager instance = new NetManager();

    }

    public static NetManager getInstance() {
        return Holder.instance;
    }

    public void show(String name) {
        System.out.println("show:" + name);
    }





    // 使用端使用
    public static void client() {
       NetManager.getInstance().show("Derry1");
    }
    public static void main(String[] args) {
        client();
    }

}
