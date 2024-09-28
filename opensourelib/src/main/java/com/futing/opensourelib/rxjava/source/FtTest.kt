package com.futing.opensourelib.rxjava.source

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by futing on 2024/8/18.
 */

fun main() {
//    Looper.prepareMainLooper()
//    Looper.loop()
    //切线程
    Thread(kotlinx.coroutines.Runnable {
//        println(Thread.currentThread())
        rxjavathreadsource()
    }).start()

//    rxjavathreadsource()
}

fun rxjavathreadsource() {

// TODO: 为什么加个object
    Observable.create( // 自定义source
        object : ObservableOnSubscribe<String?> {
            @Throws(Exception::class)
            override fun subscribe(e: ObservableEmitter<String?>) {
                println("自定义source: " + Thread.currentThread().name)
                e.onNext("Derry")
            }
        }) // ObservbaleCreate.subscribeOn
        // TODO 第二步     new IOScheduler ---> 线程池 传递进去

        .subscribeOn( // TODO 第一步  到底干了什么 （ new IOScheduler ---> 线程池）
            Schedulers.io() // 耗时读取的异步
            // Schedulers.newThread() // 开启新线程

        ) // TODO: 2024/8/18 A线程. subscribe    无论切不切换线程，onSubscribe 一直处于当前A线程
        // A线程. subscribe
        //  ObservableSubscribeOn.subscribe
        // TODO: 2024/8/18  fun main 好像用不了这个吗，就不要研究了
        .observeOn(AndroidSchedulers.mainThread())

        .subscribe( // 终点
            object : Observer<String?> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribeThread：" + Thread.currentThread().name)
                }

                override fun onNext(t: String) {
                    println("onNext::$t${Thread.currentThread().name}")
//                    onComplete()
                }


                override fun onError(e: Throwable) {
                    println("onError${e.printStackTrace()}")
                }

                override fun onComplete() {
                    println("onComplete::${Thread.currentThread().name}")
                }
            })

}