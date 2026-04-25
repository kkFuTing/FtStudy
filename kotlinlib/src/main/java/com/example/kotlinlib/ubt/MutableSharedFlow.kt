package com.example.kotlinlib.ubt

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by ting.fu on 2025/3/26.
 */


fun main() {
    runBlocking {

        // 创建一个MutableSharedFlow
        val sharedFlow = MutableSharedFlow<Int>(replay = 1) // 最多保留一个值

        // 第一个订阅者
        launch {
            sharedFlow.collect { value ->
                println("Subscriber 1 received: $value")
            }
        }

        // 第二个订阅者
        launch {
            sharedFlow.collect { value ->
                println("Subscriber 2 received: $value")
            }
        }

        // 发布数据
        sharedFlow.emit(1) // 发布一个事件

        val first = sharedFlow.first()
        println("first:$first")
        // 延时一会儿，确保订阅者能够接收到数据
        delay(1000)
        // 第三个订阅者
        launch {
            sharedFlow.collect { value ->
                println("Subscriber 3 received: $value")
            }
        }

        delay(2000)

        println("finish")


    }
}
