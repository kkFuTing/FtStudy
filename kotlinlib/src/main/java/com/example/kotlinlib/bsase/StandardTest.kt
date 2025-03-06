package com.example.kotlinlib.bsase

import android.provider.Settings.Global
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by ting.fu on 2025/3/5.
 * 自己写的
 *https://kotlinlang.org/docs/scope-functions.html#context-object-this-or-it
 */
fun main() {
    val str = "Hello"
    // this //run, with, and apply
    str.run {
        println("The string's length: $length")
        println("The string's length: ${this.length}") // does the same
    }

    // it//let and also r
    str.let {
        println("The string's length is ${it.length}")
    }
    testLifeCycle("")
    val aC: String? = null
    println("${Thread.currentThread()}")


    Thread.sleep(10000)

//    testLifeCycle()
}

enum class VendorAsr { IFly, Aiui, Academy }

fun testLifeCycle(@NonNull a: String) {


}