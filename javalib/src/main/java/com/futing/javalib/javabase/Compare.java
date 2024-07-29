package com.futing.javalib.javabase;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Date;

/**
 * Created by futing on 2024/6/19.
 */
public class Compare {
    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = new String("Hello");
        String str3 = str1;//引用传递
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));



//false
//true
//false
//true
//true
//true
    }

    public void test() {
        String a = "";
        if (a.equals("c")) {

        }

        Integer aI = 1;
        if (aI.equals(3)) {

        }

        Date date = new Date();
        if (date.equals(a)) {

        }

    }
}
