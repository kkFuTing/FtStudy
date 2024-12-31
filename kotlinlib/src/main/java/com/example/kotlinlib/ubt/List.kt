package com.example.kotlinlib.ubt

/**
 * Created by ting.fu on 2024/12/4.
 */
fun main() {
    var callback1Success: Boolean? = null
    val booleanArray: Array<Boolean?> = arrayOfNulls(3)

    println(callback1Success)
    println(booleanArray[0])
    println(booleanArray[1])
    println(booleanArray[2])

    val allTrue = booleanArray.all { it == true }
    println(allTrue)  // 如果所有元素都是 true，输出 true，否则输出
    if (booleanArray[0]==null){
        booleanArray[0] =true
        println("=====${booleanArray[0]}")

    }
    if (booleanArray[0]==null){
        booleanArray[0] =false
        println("+++${booleanArray[0]}")

    }
    println("00000000==========${booleanArray[0]}")

    for (i in 0 until 3) {
        booleanArray[i] = true
    }// false
    val allTrue1 = booleanArray.all { it == true }
    println(allTrue1)  // 如果所有元素都是 true，输出 true，否则输出 false
    for (i in 0 until 3) {
        booleanArray[i] = true
    }// false

    booleanArray[0] = false
    val allTrue2 = booleanArray.all { it == true }
    println(allTrue1)  // 如果所有元素都是 true，输出 true，否则输出 false

}