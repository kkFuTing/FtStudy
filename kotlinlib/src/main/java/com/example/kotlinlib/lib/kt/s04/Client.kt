package com.example.kotlinlib.lib.kt.s04

import java.io.File
//扩展函数的增加 （使用）
fun main() {
    val stu = Student()
    stu.add(100, 200)

    // KT本来就有
    val file = File("///")
    //kotlin 增加的扩展函数
    file.readText()
    //kotlin 增加的扩展函数（就近原则，本来也增加了）
    file.show()
}

// 扩展 函数  (Student 里面没有这个add)
fun Student.add(n1: Int, n2: Int) {
    println("结果：${n1 + n2}")
}

fun Student.show() {
    println("Student show")
}

// 给 java File 增加 扩展函数
fun File.show() {
    println("给 java File 增加 扩展函数")
}