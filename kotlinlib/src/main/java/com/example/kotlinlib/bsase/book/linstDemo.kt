package com.example.kotlinlib.bsase.book

/**
 * Created by futing on 2024/9/28.
 */
fun main() {
    //不可变结合，无法增删改  等同于java的arraylist
    val list = listOf("apple", "banana", "Orange")
    val lambda = { fruit: String -> fruit.length }
    list.maxBy(lambda)

    list.maxBy({ fruit: String -> fruit.length })
    //1. 当lambda参数是函数的最后一个参数时，可以移到括号外面；
    list.maxBy() { fruit: String -> fruit.length }
    //2.lambda参数是函数唯一参数时，可以省略括号；
    list.maxBy { fruit: String -> fruit.length }
    //3.类型推导机制，大多情况下不用声明类型
    list.maxBy { fruit -> fruit.length }
    //4.列表只有一个参数时候，不用声明，而是用it
    list.maxBy { it.length }

    //转换为大写
    val listmap = list.map { it.uppercase() }
    val newList = list.filter { it.length <= 5 }


    //可变集合
    val mutableListOf = mutableListOf("a", "b")
    mutableListOf.add("c")
    mutableListOf.add("d")


    val set = setOf("a", "b", "c", "c")
    for (s in set) {
        println(s)
    }

    val mutableSet = mutableSetOf("a", "b", "c", "c")
    mutableSet.add("b")


    //hashMap写法一
    val hashMap = HashMap<String, Int>()
    //hashmap与java写法最相似的地方
    hashMap.put("a", 1)
    hashMap.put("b", 2)
    hashMap.put("c", 3)
    //推荐的写法
    hashMap["mya"] = 0
    //读取
    val value = hashMap["a"]

    //hashMap写法二 to 不是关键字，而是infix函数
    val maps = mapOf("a" to 1, "b" to 2)
    for ((key, value) in maps) {
        println(key)
        println(value)
    }
    //hashMap写法三： maueteMaps to 不是关键字，而是infix函数
    val maueteMaps = mutableMapOf("a" to 1, "b" to 2)
    maueteMaps["C"] = 3


}