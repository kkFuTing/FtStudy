package com.futing.myjetpack.roomdemo01;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//新实体 如果需要再加到数据库中去AppDatabase
@Entity
public class Person {
    @PrimaryKey
    private int name;

    //地址是个对象类型 ，就加@Embedded注解
    @Embedded
    private Address address;

    public Person(int name, Address address) {
        this.name = name;
        this.address = address;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}







