package com.example.kotlinlib.lib.core_update

val name = "A"
val age = 999
val sex = 'M'

fun func() {
    println("我就是我")
}

fun main() {
    /*age.myApply()
    sex.myApply()
    func().myApply()*/

    // myApply 类似于 链式调用 ...
    val length = name.myApply() {

    }.myApply {

    }.myApply {
        "AAAAAA"

//    }.length as Double 2024.08.24 这个不行了 运行报错，换成下面的了
    }.length.toDouble()

    val r = name.myAlso {

    }.myAlso {
        it.length
    }.myAlso {
        it.length
    }.length.toString()


    name.myLet {
        // 你传入了一个T==this  参数1==it        it.length
    }

    name.myLet2 {
//todo 2024.08.24自己的理解        it.length 此时是不能有it的，因为是T的匿名函数 ，直接输出length就行，因为此时已经在this的匿名环境下
        length
        length
        length
    }
}

//给泛型增加一个扩展函数
// 默认 无参数的
fun <T> T.myApply(mm: () -> Unit) : T {
    // T == this
    mm()
    return this
}

fun <T> T.myAlso(mm: (T) -> Unit) : T{
    // T == this
    // it == T == this == name
    mm(this)
    return this
}

//根据返回的类型 一直在变
// (it.length) ------------ it == T == this == name
fun <T, R> T.myLet(mm: (T) -> R) : R = mm(this)

// 不想要it     给 T 增加”匿名的扩展函数“  ==  把this 带过去 ，并且，此函数 形参是T
fun <T, R> T.myLet2(mm: T.() -> R) : R {
    return mm()
}

