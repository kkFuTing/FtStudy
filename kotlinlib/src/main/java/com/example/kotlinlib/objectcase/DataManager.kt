package com.example.kotlinlib.objectcase

import android.content.ClipData.Item

/**
 * Created by futing on 2024/8/1.
 *
 * bject 关键字是一个强大且灵活的工具，它提供了对象声明、伴生对象和对象表达式三种不同的使用方式。
 *
 * 对象声明是 Object 关键字的一种用法，它允许我们创建一个单例对象，同时可以定义属性、方法和初始化逻辑。对象声明适用于以下场景：
 *
 */
//实例
//DataManager 是一个单例对象，我们可以通过 DataManager.addData(item) 和 DataManager.getData() 访问其方法。
object DataManager {
    //    listOf()是Kotlin的标准库函数，它返回一个不可变的列表（实现了List接口）。
//    mutableListOf()是Kotlin的标准库函数，它返回一个可变的列表（实现了MutableList接口）。
    private val data = mutableListOf<String>()
    fun addData(item: String) {
        data.add(item)
    }

    fun getData(): List<String> {
        return data
    }
}
/**
 * 注：在多线程环境中，对象声明的初始化是由 JVM 在类加载过程中进行的。
 * JVM 保证了类的初始化在多线程环境中的安全性，确保只有一个线程能够完成对象的实例化过程。因此，在多线程环境下的并发访问，对象声明是线程安全的。
 */
