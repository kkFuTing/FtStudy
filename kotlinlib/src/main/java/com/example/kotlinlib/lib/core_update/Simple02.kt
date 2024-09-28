package com.example.kotlinlib.lib.core_update

fun main() {

    // 以前 { 里面直接把事情干了 }
    //写法1：
    t01() {
        ""
    }


    //写法2：
    //表现 拿到 run01 函数，
    t01(::run01)

    // ::  == 拿到 run01 函数  （run01 变成函数类型的对象）
    //写法3：
    val r01 = ::run01
    val r02 = r01
    t01(r02)

}

//函数用上 Lambada 就是高阶
fun t01(mm: (Int) -> String) {
    println(mm(88))
}

fun run01(number: Int): String = "OK $number"