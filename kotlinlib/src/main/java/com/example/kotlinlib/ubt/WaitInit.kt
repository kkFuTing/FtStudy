package com.example.kotlinlib.ubt

/**
 * Created by ting.fu on 2024/12/12.
 */

import kotlinx.coroutines.*
class WaitInit {
    private val initDeferred = CompletableDeferred<Boolean>()

    // 模拟初始化操作
    suspend fun initialize() {
        delay(1000)  // 假设这是初始化操作
        initDeferred.complete(true)
    }

    suspend fun task1() {
        initDeferred.await()
        println("Task 1 started after initialization.")
    }

    suspend fun task2() {
        initDeferred.await()
        println("Task 2 started after initialization.")
    }
}

fun main() = runBlocking {
    val myClass = WaitInit()

    // 启动多个协程等待初始化
    launch {
        myClass.task1()
    }
    launch {
        myClass.task2()
    }

    // 初始化后启动任务
    myClass.initialize()
}
