package com.futing.javalib.javabase;

/**
 * Created by futing on 2024/6/13.
 */
public class Transfer {
    public static void main(String[] args) {
        int num = 1;
        System.out.println("changeNum() method call before:num = " + num);
        changeNum(num);
        System.out.println("changeNUm() method call after:num =" + num);


        Person person = new Person();
        System.out.println(person);
        changePerson(person);

        System.out.println(person);
    }

    private static void changePerson(Person P) {
        P = new Person();
    }

    private static void changeNum(int x) {
        x = 10;
    }

    static class Person {

    }
}
