package com.example.kotlinlib.lib.java.s01;

import com.example.kotlinlib.lib.kt.s01.MyUtils;
import com.example.kotlinlib.lib.kt.s01.MyUtilsKt;

public class Client {

    public static void main(String[] args) {

         MyUtilsKt.show("Derry1");

        new MyUtils().show("new Derry2");
    }

}
