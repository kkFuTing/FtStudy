package com.example.kotlinlib

import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinlib.coverkotlin.User
import com.example.kotlinlib.coverkotlin.UserNullValue1
import com.example.kotlinlib.coverkotlin.UserNullable
import com.example.kotlinlib.objectcase.NetworkManager
import com.example.kotlinlib.objectcase.Repository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Android Jetpack Compose中用于实现沉浸式状态栏的一种方法
//        enableEdgeToEdge()
//        直接new一个kotlin类型的eactivity的话 UI是layoutd



        //var lastName: String? = null 要带问好才行要不然无法赋值
//        val user = User("futing")
        val user = User("futing","jingjing")

        val userNULL = UserNullable("jane") //same as UserNullableJane", null)
        val userNULL1 = UserNullable("jane",null) //same as User("Jane", null)
        val userNULLVaule = UserNullValue1(lastName = "futing") //same as User(null, "Doe")
        val userNULLVaule1 = UserNullValue1(null, "futing")

        val users = Repository.instance?.getUser()
//        val userNames = Repository.instance?.formattedUserNames()

        //伴生对象使用
        NetworkManager.performRequest("https://blog.csdn.net/qq_42751010/article/details/134826937")

        setContentView(R.layout.activity_main_kotlin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun coroutines(){
        //默认在UI线程中启动协程
        MainScope().launch {


        }

    }
}