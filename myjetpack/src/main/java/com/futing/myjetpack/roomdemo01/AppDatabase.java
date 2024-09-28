package com.futing.myjetpack.roomdemo01;


import androidx.room.Database;
import androidx.room.RoomDatabase;
//    使用room步骤三：@Database数据库表示   表示表entities = {Student.class,Address.class} version数据库升级以及迁移用的   数据结构有变化要加上exportSchema=false 否则运行不成功
//抽象类，
@Database(entities = {Student.class,Address.class},version = 1,exportSchema = false)
//给一个abstract抽象类，最后apk 会给他这个代码生成一个实例
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao userDao();
}
