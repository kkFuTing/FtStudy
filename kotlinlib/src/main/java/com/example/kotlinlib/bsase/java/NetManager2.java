package com.example.kotlinlib.bsase.java;

// TODO　Java 单例模式2
public class NetManager2 {

   private static NetManager2 instance;

   public static NetManager2 getInstance() {
       if (instance == null) {
           instance = new NetManager2();
       }
       return instance;
   }

    public void show(String name) {
        System.out.println("show:" + name);
    }





    // 使用端使用
    public static void client() {
        NetManager2.getInstance().show("Derry2");
    }

    public static void main(String[] args) {
       client();
    }
}
