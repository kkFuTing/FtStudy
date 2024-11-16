package com.example.kotlinlib.ubt

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

/**
 * Created by ting.fu on 2024/11/13.
 */



private val gson: Gson = GsonBuilder().create()
fun main() {

    lateinit var bsWeight: String

//
//    val type = object : TypeToken<List<List<Float>>>() {}.type
//    val bsWeightMat = gson.fromJson<List<List<Float>>>(bsWeight, type)
//    if (bsWeightMat != null) {
//        println("headLaunch ->Thread=${Thread.currentThread().name}")
//        jsonDataSend4Head(bsWeightMat)
//    } else {
//        println("数据异常！无法转成bsWeightMat，bsWeight=$bsWeight")
//    }
    imedite()
}
val initialFloatList: MutableList<Float?> = mutableListOf(1.1f, 2.2f, 3.3f, null)
//val initialFloatList: MutableList<Float> = mutableListOf(1.1f, 2.2f, 3.3f, null)
//val initialFloatList: MutableList<Float> = mutableListOf(1.1f, 2.2f, 3.3f)

fun imedite() {
    var angleSum = 0F
    for (num in initialFloatList) {
        if (num != null) {
            angleSum += num
        }
        println(num)
//                angleSum += num
    }

}
