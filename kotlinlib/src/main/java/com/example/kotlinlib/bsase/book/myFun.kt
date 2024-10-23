package com.example.kotlinlib.bsase.book

import kotlin.math.max

/**
 * Created by futing on 2024/9/28.
 */

fun main() {
//    println(largerNumber(8, 2))
//    println(largerNumber2(8))
//    println(largerNumberDefault(8))

//    println(largerNumberDefault1(num2 = 8))

    standard()
}

fun standard() {
    //常用标准函数学习
//    1.let
    val lists = listOf("apple", "banana", "orange")
    lists?.let {
        val map = it.map {
            it.uppercase()
        }
        for (s in map) {
            println(s)
        }
    }

//    2.with

//    不用with实现
//    val stringBuilder = StringBuilder()
//    for (list in lists) {
//        stringBuilder.append(list).append("\n")
//    }
//    stringBuilder.append("Ate all fruits")
//    val result = stringBuilder.toString()
//    println(result)

//  使用with等同于上面

    val result = with(StringBuilder()) {
        for (list in lists) {
            append(list).append("\n")
        }
        append("Ate all fruits")
        toString()
    }
    println(result)

    // 3.run
    val runResult = StringBuilder().run {
        for (list in lists) {
            append(list).append("\n")
        }
        append("Ate all fruits")
        toString()//牢记最后一行为返回值
    }
    println(runResult)

    // 4.apply  c
    val applyResult = StringBuilder().apply {
        for (list in lists) {
            append(list).append("\n")
        }
        append("Ate all fruits")
    }
    //此时applyResult为StringBuilder
    println(applyResult.toString())

}

fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

//当一个函数只有一行代码时，允许不写函数体，可以写在尾部用 = 连接,此时return省略
fun largerNumber1(num1: Int, num2: Int): Int = max(num1, num2)

//largerNumber1 = 可以推导出是int类型，所以返回声明类型可以省略1
fun largerNumber2(num1: Int, num2: Int) = max(num1, num2)

//有默认值后，可以传第二参数或否
fun largerNumberDefault(num1: Int, num2: Int = 6) = max(num1, num2)

fun largerNumberDefault1(num1: Int = 1, num2: Int) = max(num1, num2)
