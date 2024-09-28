package com.example.kotlinlib.project.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinlib.project.databse.Student
//3.数据库
// java  entities = {}
// kt entities = []

//version 数据库的版本号；
@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    // 最终给用户的就是 DAO
    abstract fun getStudentDao() : StudentDao

//    单例的意思
    companion object {

        private var INSTANCE : StudentDatabase ? = null

//    函数
        // Application
        fun getDatabase(context: Context) : StudentDatabase ? {

            if (INSTANCE == null) {
                //把StudentDatabase 实例化，  Room的底层是java 所有才需要传入StudentDatabase::class.java  否则传入StudentDatabase::class 但是我点击去看是kt呀
//                INSTANCE = Room.databaseBuilder(context, StudentDatabase::class.java, "student_database.db")
                INSTANCE = Room.databaseBuilder(context, StudentDatabase::class.java, "student_database.db")
                    .allowMainThreadQueries() // 允许在主线程运行
                    .build()
            }

            return INSTANCE

        }

        //模仿源码，使用给其他地方用；
        fun getDatabase() : StudentDatabase? = INSTANCE

    }

}