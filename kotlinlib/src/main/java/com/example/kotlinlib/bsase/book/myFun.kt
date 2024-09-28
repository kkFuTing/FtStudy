package com.example.kotlinlib.bsase.book

import kotlin.math.max

/**
 * Created by futing on 2024/9/28.
 */

fun main() {
    println(largerNumber(8, 2))
}

fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

//当一个函数只有一行代码时，允许不写函数体，可以写在尾部用 = 连接,此时return省略
fun largerNumber1(num1: Int, num2: Int): Int = max(num1, num2)

//largerNumber1 = 可以推导出是int类型，所以返回声明类型可以省略1
fun largerNumber2(num1: Int, num2: Int) = max(num1, num2)