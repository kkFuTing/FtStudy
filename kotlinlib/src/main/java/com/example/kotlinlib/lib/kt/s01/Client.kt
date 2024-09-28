package com.example.kotlinlib.lib.kt.s01

import com.example.kotlinlib.lib.java.s01.JavaStudent
import com.example.kotlinlib.lib.java.cb.JavaCallback
import com.example.kotlinlib.lib.java.cb.JavaManager
import com.example.kotlinlib.lib.kt.cb.KTCallback
import com.example.kotlinlib.lib.kt.cb.KtManager
import com.example.kotlinlib.lib.kt.s01.KtStudent
import kotlin.reflect.KClass

fun main() {

    // 解决冲突问题  因为in是kotlin的关键字
    println(JavaStudent.`in`)

    // 调用Java函数  String!，由于是！ 你最好 var str: String ? =
//     JavaStudent().string.length  // 错误的示范 （点出string 后面由！  表示有可能为空，用空的方式接收，就不会引发空指针异常）
    var str: String ? = JavaStudent().string
    println(str?.length)

    // Class  java kt
    showClass(JavaStudent::class.java)

    showClass2(KtStudent::class)

    // TODO kt 使用 Java Callback
    // 第一种写法   kt使用 Java Callback
    JavaManager().setCallback(JavaCallback {
        println(it)
    })

    // 第二种写法  kt使用 Java Callback
    JavaManager().setCallback(object : JavaCallback{
        override fun show(info: String?) {
            println(info)
        }
    })

    // 第三种写法 kt使用 Java Callback
    val callback = JavaCallback {
        println(it)
    }
    JavaManager().setCallback(callback)

    // 第四种写法 kt使用 Java Callback
    val callback2 = object : JavaCallback{
        override fun show(info: String?) {
            println(info)
        }
    }
    JavaManager().setCallback(callback2)


    // TODO kt 使用 tk Callback
    // 1
    KtManager().setCallback(object : KTCallback{
        override fun show(name: String) {
        }
    })

    // 2
    val c = object : KTCallback{
        override fun show(name: String) {  }
    }
    KtManager().setCallback(c)

    // Kt不能像Java一样的写法
    /*KtManager().setCallback(KTCallback{

    })*/
}

// 行参里面 java
fun showClass(clazz: Class<JavaStudent>) { }

// 全部都用 kt
fun  showClass2(clazz: KClass<KtStudent>) { }