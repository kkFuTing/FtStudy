package com.example.kotlinlib.ubt

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by ting.fu on 2025/3/27.
 */


fun main() {
    val byteArray = byteArrayOf(
        0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
        0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
        0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
        0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
        0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
        0x00.toByte(), 0x00.toByte(), 0x00.toByte(), 0x00.toByte()
    )

// 尝试将字节数组转换为 UTF-8 字符串
    val decodedString = String(byteArray, Charsets.UTF_8)
    println(decodedString)
    runBlocking {
        println("BEGIN")
        coroutineScope.launch() {
            mySuspend1()
            mySuspend2()
        }


        delay(10*1000)
    }

}

suspend fun mySuspend1() {
    println("mySuspend1 begin")
    delay(1000)
    println("mySuspend1 end")
}

suspend fun mySuspend2() {
    println("mySuspend2 begin")
    delay(2000)
    println("mySuspend2 end")
}