package com.example.kotlinlib.bsase.book


/**
 * Created by futing on 2024/9/28.
 */

fun main() {
    checkNumber(1)
}

fun largerNumber4(num1: Int, num2: Int): Int {
    var value = if (num1 > num2) {
        // ....... 省略 200行代码nu
        num1
    } else {
        // ....... 省略 200行代码nu
        num2
    }


    return value
}

fun largerNumber5(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        // ....... 省略 200行代码nu
        num1
    } else {
        // ....... 省略 200行代码nu
        num2
    }
}

fun largerNumber6(num1: Int, num2: Int) = if (num1 > num2) {
    // ....... 省略 200行代码nu
    num1
} else {
    // ....... 省略 200行代码nu
    num2
}


fun largerNumber7(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

//===================================
//is 相当于java的instanceof
//when写法1：when传入参
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("number is int ")
        is Double -> println("number is Double")
        else -> println("number is support")
    }
}

//when写法2：when 不传入参
fun getScore(name: String) = when {
    name.startsWith("fu") -> 86
    name == "Jim" -> 77
    name == "ft" -> 95
    name == "ting" -> 100
    else -> 0
}


