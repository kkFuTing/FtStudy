package com.example.kotlinlib.interview

import kotlinx.coroutines.*

suspend fun suspendFunction(callback: () -> Unit) {
    println("Starting suspend function")
    
    delay(2000) // 模拟耗时操作
    
    println("Before calling callback")
    callback() // 调用回调
    println("After calling callback")
}

fun main() = runBlocking {
    launch {
        suspendFunction {
            println("Callback executed")
        }
        println("suspendFunction end")
    }
    println("Main function continues")
}
