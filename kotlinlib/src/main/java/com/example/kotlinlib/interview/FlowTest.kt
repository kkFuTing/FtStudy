package com.example.kotlinlib.interview

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay
import okhttp3.Request
import java.time.Duration

/**
 * Created by futing on 2024/9/19.
 */
@RequiresApi(Build.VERSION_CODES.O)
fun main() = runBlocking {
    println("测试呀啊+" + Thread.currentThread().name)
//    最为通用的flow builder就是flow {...}了，
    val simple = flow {
        listOf("hello", "world", "of", "flows").forEach {
            delay(Duration.ofMillis(100))
            emit(it)
        }
    }

    simple.collect {
        println(it)
    }

    println("==================")
//    用集合创建Flow1：flowOf用于从固定数量的元素创建，多用于示例
    val flowOf = flowOf("hello", "world", "of", "flows")
    flowOf.collect { println(it) }

    println("==================")
    //用集合创建Flow2：asFlow把现有的集合转为Flow，这个还是比较实用的：
    listOf("hello", "world", "of", "flows").asFlow()
        .collect { println(it) }
    (1..5).asFlow().collect { println(it) }

    //通过flow builder,最为常用的构建其
    println("==================")
    runBlocking {
        val myflow = flow {
            for (i in 1..3) {
                delay(Duration.ofMillis(100))
                println("Emitting:$i")
                emit(i)
            }
        }

//        常见的终端操作有三个：
//        collect 最为通用的，可执行一个代码块，参数就是Flow流出的数据
        myflow.collect {
            println(it)
        }

        println("toList: ${myflow.toList()}")
        //需要注意的就是first()和single()，first是只接收数据流中的第一个，而single则要求数据流只能有一个数据（没有或者超过一个都会抛异常）。
        println("first: ${myflow.first()}")
        //???
        //注意fold和reduce的区别，这里它们的区别跟集合上的操作是一样的，fold可以提供初始值，流为空时返回初始值；而reduce没初始值，流为空时会抛异常。
        println("sum by fold: ${myflow.fold(0) { s, a -> s + a }}")

        println()
        //z转换
//        map是死板的转换,一个对象进去,另一个对象作为返回值出来
        myflow.map { "Mapping to ${it * it}" }
            .collect { println(it) }

        myflow.transform { req ->
            emit("Making request $req")
            emit(performRequest(req))

        }.collect {
            println(it)
        }


    }

}

fun performRequest(req: Int) = "Response for  $req"
