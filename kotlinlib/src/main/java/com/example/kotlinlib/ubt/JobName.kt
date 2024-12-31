package com.example.kotlinlib.ubt

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

/**
 * Created by ting.fu on 2024/11/28.
 */
fun main() {

    runBlocking {
        actionJob("A")
//        delay(1000)
//        actionJob("A")
//        delay(3000)
//        actionJob("A")
//        delay(1500)
//        println("取消并执行")
//        actionJob?.cancel()
//        actionJob("B")
//        actionJob("B")
//        actionJob("B")

        delay(10000)

    }

}

val JobNameCoroutineScope = CoroutineScope(Dispatchers.IO + Job()) // 在 IO 线程池中创建协程作用域
var currentJobName: String? = null
var actionJob: Job? = null
fun actionJob(name: String) {
    println("=================================")
    println(name == currentJobName)
    println(actionJob?.isActive)
    println(currentJobName)
    println(name)

    if (currentJobName == name && actionJob?.isActive == true) {
        println("当前要执行的正在执行")
        return
    }
    actionJob?.cancel()
    actionJob = JobNameCoroutineScope.launch(CoroutineName(name)) {
        try {
            // 访问当前协程的名称
            currentJobName = coroutineContext[CoroutineName]?.name
            println("当前协程名称：$currentJobName")
            val launch1 = launch {
                println("job1")
                delay(1000)
            }

            val launch2 = launch {
                println("job2")
                delay(2000)
            }

            arrayListOf(launch1, launch2).joinAll()
            println("all end")

            currentJobName = null;
            actionJob("A")

        } catch (e: Exception) {
            println("Exception:${e.printStackTrace()}")

        }
    }

}

