package com.example.kotlinlib.lib.core_update

fun main() {
    // Unit
    // String
    // Boolean
    // Double
    sum(10, 20,30) { i1, i2, i3 ->
        println("i1:$i1, i2:$i2, i3:$i3")  // Unit无参返回
        "OK"    // String 返回
        true
        99999.343
    }
}

// TODO 三数相乘
fun <R> sum(n1: Int, n2: Int, n3: Int, mm: (Int, Int, Int) -> R): R {
    return mm(n1, n2, n3)
}