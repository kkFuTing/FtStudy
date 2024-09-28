package com.futing.myjetpack.roomdemo01;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
//    使用room步骤四：增删改查用的  注解@Dao  其他注解如名字上 到这里就可以使用了
//这个类要求会用sql语句
@Dao
public interface StudentDao {
    @Insert
    void insert(Student... students);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);

    @Query("select * from Student")
    List<Student> getAll();

    //查询一条记录
    @Query("select * from Student where name like :name")
    Student findByName(String name);

    @Query("select * from Student where uid in(:userIds)")
    List<Student> getAllId(int[] userIds);

    @Query("select name,pwd from Student")
    public List<StudentTuple> getRecord();

    //这个要自己试的
//    @Query("select x,x,x from where student.x==address.x")

}








