package com.futing.myjetpack.roomdemo01;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

//使用room步骤N +外键 Address 把两个表连接一起的 biaoshi  @ForeignKey表示外键  Address.class作为外键使用 parentColumns = "addressId"是学生的  childColumns = "addressId"地址的id
//@Entity(foreignKeys = @ForeignKey(entity = Address.class,parentColumns = "addressId",childColumns = "addressId"))

//使用room步骤二 生成一个实体类，加上@Entity注解 键名加@PrimaryKey
@Entity
public class Student {
    // uid PrimaryKey 表示参数字段 autoGenerate  = true 可以自动增长
    @PrimaryKey(autoGenerate = true)
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    //ColumnInfo 表示 表字段的意思  如果（）没有名字 就是字段名，但是最好还是写上；
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pwd")
    private String password;
    //学生里的地址
    @ColumnInfo(name = "addressId")
    private int addressId;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", addressId=" + addressId +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Student(String name, String password, int addressId) {
        this.name = name;
        this.password = password;
        this.addressId = addressId;
    }
}
