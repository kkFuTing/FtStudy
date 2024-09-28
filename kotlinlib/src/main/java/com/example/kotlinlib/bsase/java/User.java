package com.example.kotlinlib.bsase.java;

// Java Bean
public class User {

    private int id;
    private String name;
    private char sex;

    public User() {
    }

    public User(int id, String name, char sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    // 。。。 省略
}
