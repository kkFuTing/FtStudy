package com.example.kotlinlib.bsase.book

/**
 * Created by futing on 2024/9/28.
 */


fun main() {
    for (i in 0..10) {
        println(i)
    }

    val range = 0 until 10

    println("==========================")

    //默认 为1  step 表示跳两步 升序区间
    for (i in 0 until 10 step 2) {
        println(i)
    }
    println("===========降序区间===============")

    //降序区间
    for (i in 10 downTo 1) {
        println(i)
    }


}