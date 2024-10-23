package com.example.kotlinlib.interview

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // 启动 A 的初始化
    A.initialize()

    launch {
        B.runTasks() // 启动 B 的任务
    }

    // 保持主线程活着，直到所有任务完成
    delay(6000) // 确保在主线程中保持一定时间
}
