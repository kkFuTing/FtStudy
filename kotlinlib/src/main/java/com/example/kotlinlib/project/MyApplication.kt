package com.example.kotlinlib.project

import android.app.Application
import android.util.Log
import com.example.kotlinlib.project.config.Flag
import com.example.kotlinlib.project.databse.StudentDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(Flag.TAG, "MyApplication onCreate run")

        // TODO:  不调用 导致 增加收藏没有反应哦 2024.08.23 
        // 初始化
        StudentDatabase.getDatabase(this)
    }

}