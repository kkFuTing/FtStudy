package com.example.kotlinlib.interview

import androidx.lifecycle.MutableLiveData
import com.facebook.stetho.Stetho.initialize
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by futing on 2024/10/23.

 */
//private val stateFlow = MutableStateFlow(false) // 状态流，初始为 false
//val checkResult = MutableLiveData<Boolean>() 区别
private val stateFlow = MutableStateFlow(false) // 状态流，初始为 fals
private val initDeferred = CompletableDeferred<Boolean>() // 创建一个 CompletableDeferred

fun main() {
    println(Thread.currentThread().name)
    val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    runBlocking {
//        coroutineScope.launch {
            println(Thread.currentThread().name)
            initialize()
//        stateFlow.collect {
//            println(it)
//        }
            // 等待初始化结果
            val initAudioResult = initDeferred.await()
            println("initAudioResult:$initAudioResult")
            val await = async {
                val sum = 5 + 5
                println("initAudioResult:$sum")
                delay(1000)
                sum == 10
            }.await()

            // 开始初始化
//        }
    }

}

fun initialize() {
    val initializer = Initializer()
    initializer.initialize { result ->
        initDeferred.complete(result) // 在初始化完成时设置结果
    }
}
