package com.example.kotlinlib.lib.kt.s02

fun show(name: String) {
    println("name:$name")
}

fun show2(name: String) {
    println("name:$name")
}

fun add(n1: Int, n2: Int) {
    println("resut:${n1 + n2}")
}

//不想java调用kotlin，写法就是加上` `   进行隔离;
fun `showTest`() {
    println("showTest")
}
//此时java是不能调用的， 发现不注释掉，项目跑不了
//fun `   `(sex: Char) {
//    println("sex:$sex")
//}

fun `4325436465375`(name: String) {

}

fun main() {
    `showTest`()
//    发现不注释掉，项目跑不了
//    `   `('M')
    `4325436465375`("Derry")
}