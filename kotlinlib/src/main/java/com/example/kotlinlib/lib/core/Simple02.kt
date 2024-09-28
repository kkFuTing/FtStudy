// TODO 最后看
// 首页模块第一节的 02：10左右
package com.example.kotlinlib.lib.core

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

val name: String = "Derry"
val age: Int = 0

fun common() {
    println("我就是方法")
}

fun main() {

    name.let {  }

    // r == 外面那个R
    val r = common().myRun {
        println("AAAA")
        true
        433535.45345

        '男'
//        "AAAA"  // == 里面的R泛型
    }

    println(r)

    println("==========================")
    myWith(name) {
        length
    }

    name.myLet {
        length
        length
    }

    onRun(true) {
        println("执行了..")
    }

    onRun(true, {
        println("执行了222")
    })

    onRun(false, {
        println("执行不了啦啦啦啦")
    })

    val runValue = Runnable {
        println("我就是Runnabler任务")
    }

    onRun(true, runValue::run)
}

// TODO m: T.() -> R
// T.() == 给T来一个匿名函数
fun <T, R> T.myRun(m: () -> R) : R  = m()  // 调用高阶函数
//fun <T, R> T.myRun(m: () -> R) : R   { return m()}  // 调用高阶函数 这个等同于上面


// 普通函数
fun <T, R> myWith(input:T, mm: T.() -> R): R {
    return input.mm() // this
}

fun <T, R> T.myLet(mm: T.(T) -> R): R {
    // T == this   () -> R
    // mm(this) == this     vs    T.(T)  -> R
    return mm(this)
}

// 控制器 如果你是true，我就执行你，否则不执行
inline fun onRun(isRun: Boolean,        mm: () -> Unit) {
    if (isRun) mm()
}
