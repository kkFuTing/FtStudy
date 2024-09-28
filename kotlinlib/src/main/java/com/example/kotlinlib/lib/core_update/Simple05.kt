package com.example.kotlinlib.lib.core_update

import com.example.kotlinlib.lib.core.myRun
import kotlin.concurrent.thread

// TODO 实战    Kotlin有很多的 kt糖
fun main() {
    //me：函数后面+{} 直接定义lambada啦？？
    ktrun() {
        doCounts(10) {
            println("执行了一次  下标是:$it")
            println(Thread.currentThread().name)
        }
    }

    //这是系统的线程
    thread {  }
}

// 自定义轮询器  传入 9  我就给你 轮询9次
fun doCounts(counts: Int, mm:(Int) -> Unit) {

    // 0 1 2 3 4 5 6 7 8
    for (index in 0 until counts) {
        mm(index)
    }

}

// 自定义线程封装
fun ktrun(
    start: Boolean = true,
    name: String ?  ="DerryThread",
    // ... 省略
    myRunAction: () -> Unit) : Thread {

    println(name)
    val thread = object : Thread(name.toString()  ) {
        override fun run() {
            super.run()

            myRunAction()
        }
    }
//    name ?: "DerryThread"

    if (start)
        thread.start()

    return thread
}