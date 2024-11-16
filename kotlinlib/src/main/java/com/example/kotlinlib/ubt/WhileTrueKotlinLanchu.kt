package com.example.kotlinlib.ubt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Created by ting.fu on 2024/11/12.
 * 发现 delay 可以被取消
 * 发现 delay 可以被取消  不行
 *
 * joinAll学习
 *
 * onSynthesisData:ttsLaunch.isActive=true
 * onSynthesisData:ttsLaunch.isCompleted=false
 * onSynthesisData:ttsLaunch.isCancelled=false
 * onSynthesisData:phonemeLaunch.isActive=false
 * onSynthesisData:phonemeLaunch.isCompleted.=false
 * onSynthesisData:phonemeLaunch.isCancelled=true
 * 3送入音频事件
 * onSynthesisData:audioLaunch.isActive=false
 * onSynthesisData:audioLaunch.isCompleted=true
 * tts submit：ttsRequest= {"app":{"appid":"2258015624","cluster":"volcano_tts","token":"7f5DO44IcYUBZPLJw7S1h5mV1EOud21l"},"audio":{"bits":16,"channel":1,"compression_rate":1,"emotion":"chat","encoding":"pcm","language":"cn","pitch_ratio":1.0,"rate":16000,"speed_ratio":0.9,"voice_type":"BV700_streaming","volume_ratio":1.5},"request":{"frontend_type":"unitTson","operation":"submit","reqid":"0dbf3038-1fd8-4a10-b750-6da088dffee6","text":"<speak><break time=\"0.1s\"></break>嗨，</speak>","text_type":"ssml","with_frontend":1},"user":{"uid":"2101163309"}}
 * doSynthesisNext：requestQueue.size=0
 * onSynthesisData:audioLaunch.isCancelled=true
 * phonemeLaunch&audioLaunch 等咯
 *
 * 执行下面关键代码,phonemeLaunch.isCompleted.=false   phonemeLaunch.isCancelled=true 导致无法完成
 *
 *      Timber.i("phonemeLaunch&audioLaunch 等咯")
 *      arrayListOf(phonemeLaunch, audioLaunch).joinAll()
 *      Timber.i("phonemeLaunch&audioLaunch 都完成了")
 *
 *      我发现一个问题就是,我cancel了,但是isCompleted->仍然为false  也就是 isCompleted.=false->里面的子协程还在跑 ->就算不跑了也退不出来;
 *      我在for循环做了判断,如果 is    if (!isActive) break
 *      但是还是会存在一个问题,也就是取消了 phonemeLaunch.isCompleted.=false  phonemeLaunch.isCancelled=true 导致一直卡在arrayListOf(phonemeLaunch, audioLaunch).joinAll()
 *
 *
 */

fun main() {
    runBlocking {
        val job = Job() // 创建一个 Job 用于管理协程
        val coroutineScope = CoroutineScope(Dispatchers.IO + job) // 在 IO 线程池中
        var aLaunch: Job? = null
        var bLaunch: Job? = null
        var cLaunch: Job? = null
        val allLaunch = coroutineScope.launch {
            println("all= ${Thread.currentThread().name}")
            cLaunch = launch(Dispatchers.IO) {
//                这样感觉又可以停下来
//                while (true) {
//                    delay(1000)
//                    println("C=${isActive}")
//                }

                while (true) {
                    for (i in 0 until 10000) {
                        println("C=${isActive}")
                        delay(200)

                    }
                }
            }
//
//            println("All wait ready join  =${Thread.currentThread().name}")
//            println("All wait join =${Thread.currentThread().name}")
//            println("All finish ready wait 4000ms =${Thread.currentThread().name}")
//            delay(4000)
//            println("All wait 4000ms =${Thread.currentThread().name}")
        }
        println("allLaunch.isCancelled before is cancel=${allLaunch.isCancelled}")
        Thread.sleep(10000)
        allLaunch.cancel()

        println("allLaunch.isCancelled=${allLaunch.isCancelled}")
        println("aLaunch.isCancelled=${aLaunch?.isCancelled}")
        println("bLaunch.isCancelled=${bLaunch?.isCancelled}")
        println("cLaunch.isCancelled=${cLaunch?.isCancelled}")

        cLaunch?.join()
        println("cLaunch end=${cLaunch?.isCancelled}")

//    aLaunch?.cancel()
//    bLaunch?.cancel()
//    cLaunch?.cancel()


        Thread.sleep(12000)
        println("allL end = ${allLaunch.isCancelled}")

    }

}

suspend fun goNewLaunch3() {
    withContext(Dispatchers.IO) {
        delay(5000)
        println("withContext(Dispatchers.IO) =${Thread.currentThread().name}")

    }
}
