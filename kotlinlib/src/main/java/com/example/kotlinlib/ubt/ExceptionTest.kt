package com.example.kotlinlib.ubt

import java.io.IOException
import java.net.SocketException

/**
 * Created by ting.fu on 2025/3/4.
 */

fun main() {
//    println("ABC")
//    testException() //抛异常

    val  a = 1;
    a.let {

    }
    try {
        testException()
    } catch (e: Exception) {
        println("is Exception")
//        println("输出异常：${e.printStackTrace()}")
    }


    try {
        testException()
    } catch (e: IOException) {
        println("is IOException")
//        println("输出异常：${e.printStackTrace()}")
    }

    try {
        testIOException()
    } catch (e: IOException) {
        println("is SocketException")
//        println("输出异常：${e.printStackTrace()}")
    }
    try {
        testIOException()
    } catch (e: SocketException) {
        println("is IOException")
//        println("输出异常：${e.printStackTrace()}")
    }


}

fun testException() {
    throw SocketException("SOCKET 通信异常测试")
}

fun testIOException() {
    throw IOException("IOException 通信异常测试")
}
