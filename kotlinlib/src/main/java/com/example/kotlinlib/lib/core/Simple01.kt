// TODO  第3看这个

package com.example.kotlinlib.lib.core

val nameS: String = "Derry"
val ageS: Int = 0

fun commonOk() {
    println("我就是方法")
}

fun main() {
    commonOk().myRunOk {
        true
    }

    nameS.myRunOk {
        false
    }

    ageS.myRunOkT {
        println("myRunOkT")
        false
    }
}

// T.() 给万能类型 增加 匿名函数        只不过这个匿名函数 在 高阶函数中
// () 就是高阶函数

// 给 ”万能类型“ 类型 增加了扩展函数  一增加   方法.myRunOk   （此处的 mm: 万能类型.() -> Boolean  是高阶函数）
fun <万能类型> 万能类型.myRunOk(  mm: 万能类型.() -> Boolean  ) {
    mm() // 执行高阶
}

fun <T> T.myRunOkT(  mm: () -> Boolean  ) {
    mm() // 执行高阶
}