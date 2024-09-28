package com.futing.opensourelib.rxjava.source1

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by futing on 2024/8/18.
 */
fun main() {
//    testHook()
    sourceactivity2()


}

fun sourceactivity2() {

    // 结论： new ObservableCreate() {source == 自定义source}
    // 2：Observable创建过程 源码分析
    Observable.create<String> // 自定义source
    { emitter -> // 发射器.onNext
        emitter.onNext("A")
        emitter.onComplete()
    } // 3：subscribe订阅过程 源码分析
        // ObservableCreate. subscribe
        .subscribe( // 自定义观察者
            // 1：Observer 源码看看
            object : Observer<String?> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribeThread：" + Thread.currentThread().name)
                }

                // TODO: https://blog.csdn.net/github_34402358/article/details/107718802 kotlin 有todo代码会报错


                override fun onNext(t: String) {
                    println("onNext::$t")
                    onComplete()

                }


                override fun onError(e: Throwable) {
                    // TODO: 如果在Actity执行就不会出错了
                    println("onError${e.printStackTrace()}")
                }

                override fun onComplete() {
                    println("onComplete")
                }
            })

}

fun testHook() {
    Observable.create<Any> { e -> e.onNext("A") } // null.map

        .map { true }

        .subscribe {
            println("结果")
        }
}