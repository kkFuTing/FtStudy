package com.example.kotlinlib.ubt

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.system.measureTimeMillis

/**
 * Created by ting.fu on 2025/4/27.

 */


fun main() = runBlocking {

    try {
        val time = measureTimeMillis {
            withTimeoutOrNull(5000) {  // 设置超时时间为 5000 毫秒 (5 秒)
                // 假设挂载的操作是一个耗时的操作
                longRunningOperation()
            }
        }
        println("Operation completed in $time ms")
    } catch (e: TimeoutCancellationException) {
        println("Operation timed out!")
    }
}

suspend fun longRunningOperation() {
    // 模拟一个长时间运行的任务，例如网络请求或计算
    while (true){
        delay(100)
        println("123")
        long()
    }
    delay(6000)  // 模拟6秒钟的延迟
    println("Operation completed")
    long()
}

suspend  fun long() {
    while (true){

    }
    delay(8000)  // 模拟6秒钟的延迟
    println("Operation completed1")
    TODO("Not yet implemented")
}
