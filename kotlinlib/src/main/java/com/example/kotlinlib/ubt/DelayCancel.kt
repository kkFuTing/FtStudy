package com.example.kotlinlib.ubt

import android.telephony.ims.RcsUceAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by ting.fu on 2024/11/15.
 * 实时cancel功能
 */
fun main() {
//    runBlocking {
//        for (i in 0 until 10) {
//            delay(500)
//            cancelAsr()
//        }
//        cancelAsr()
//    }

    //正常，可以取消；
//    coroutineScope.launch {
//        println("coroutineScope.launch Thread=${Thread.currentThread().name}")
//        repeat(100) {
//            delay(1000)
//            cancelAsr()
//        }
//    }

    coroutineScope.launch {
        println("coroutineScope.launch1 Thread=${Thread.currentThread().name}")
        launch {

            println("cancelAsrLaunch.launch2 Thread=${Thread.currentThread().name}")
        }
        repeat(100) {
            delay(1000)
            cancelAsr()
            cancelAsr()
            cancelAsr()
        }
    }
    Thread.sleep(20000)
}

var cancelAsrLaunch: Job? = null;
val coroutineScope = CoroutineScope(Dispatchers.IO + Job()) // 在 IO 线程池中创建协程作用域


fun cancelAsr() {
    cancelAsrLaunch?.cancel()
    println("cancelAsr:delay begin")
    cancelAsrLaunch = coroutineScope.launch {
        println("cancelAsrLaunch.launch Thread=${Thread.currentThread().name}")
        println("cancelAsr:delay begin")
        delay(5000)
        println("cancelAsr:is  $isActive")
        println("cancelAsr:delay FINISH")
//            asrContinueControl(false)
    }

}