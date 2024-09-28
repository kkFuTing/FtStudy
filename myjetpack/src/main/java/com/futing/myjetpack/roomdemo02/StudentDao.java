package com.futing.myjetpack.roomdemo02;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

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


    //有数据变化都会用 Livedata
    //使用Livedata
    @Query("select * from Student order by uid")
    LiveData<List<Student>> getAllLiveDataStudent();


}







