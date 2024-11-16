package com.example.kotlinlib.ubt

import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by ting.fu on 2024/11/12.
 */

fun main() {
    val job = Job() // 创建一个 Job 用于管理协程
    val coroutineScope = CoroutineScope(Dispatchers.IO + job) // 在 IO 线程池中
    var aLaunch: Job? = null
    var bLaunch: Job? = null
    val allLaunch = coroutineScope.launch {
        println("all= ${Thread.currentThread().name}")
        aLaunch = launch(Dispatchers.IO) {
            println("A1=${Thread.currentThread().name}")
            Thread.sleep(2000)
            println("A2=${Thread.currentThread().name}")
            Thread.sleep(4000)
            println("A3=${Thread.currentThread().name}")
            goNewLaunch()
        }

        bLaunch = launch(Dispatchers.IO) {
            println("B1=${Thread.currentThread().name}")
            Thread.sleep(5000)
            println("B2=${Thread.currentThread().name}")
        }

        Thread.sleep(4000)
        println("All wait 4000ms =${Thread.currentThread().name}")
    }
    println("allLaunch.isCancelled before is cancel=${allLaunch.isCancelled}")
    Thread.sleep(3000)
    allLaunch.cancel()
    aLaunch?.cancel()
    bLaunch?.cancel()


    /**
     * 不加    aLaunch?.cancel()
     *     bLaunch?.cancel()
     *     的结果
     * allLaunch.isCancelled before is cancel=false
     * all= DefaultDispatcher-worker-1
     * A1=DefaultDispatcher-worker-3
     * B1=DefaultDispatcher-worker-1
     * A2=DefaultDispatcher-worker-3
     * allLaunch.isCancelled=true
     * B2=DefaultDispatcher-worker-1
     * withContext(Dispatchers.IO) =DefaultDispatcher-worker-3
     * allL end = true
     *
     *
     */
    println("allLaunch.isCancelled=${allLaunch.isCancelled}")
    println("aLaunch.isCancelled=${aLaunch?.isCancelled}")
    println("bLaunch.isCancelled=${bLaunch?.isCancelled}")

    Thread.sleep(12000)
    println("allL end = ${allLaunch.isCancelled}")

}

suspend fun goNewLaunch() {
    withContext(Dispatchers.IO) {
        Thread.sleep(5000)
        println("withContext(Dispatchers.IO) =${Thread.currentThread().name}")

    }
}
