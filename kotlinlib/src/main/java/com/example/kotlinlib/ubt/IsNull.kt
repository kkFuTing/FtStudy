package com.example.kotlinlib.ubt

/**
 * Created by ting.fu on 2024/11/20.
 */
var newCallback: ((String) -> Unit)? = null

fun main() {
    println("开始测试")
    setCallback {
        println("输出返回值")
        println(it)
    }

    println("开始测试:newCallback=$newCallback")
    if (newCallback != null) {
        newCallback.let {
            println("不为空")
            if (it != null) {
                it("返回值")
            }
        }

    }

    newCallback?.let {
        println("let 测试=>")
        it("let 的结果呀")
    }

    println("返回否!!")

   setCallback(null)  //不注释输出  返回了,无法输出!!  注释 则无法输出出

    newCallback?.let {
        println("let 测试=>return")
        it("let 返回")
        return
    }
    println("返回了,无法输出!!")


}

fun setCallback(callBack: ((result: String) -> Unit)? = null) {
    newCallback = callBack
}