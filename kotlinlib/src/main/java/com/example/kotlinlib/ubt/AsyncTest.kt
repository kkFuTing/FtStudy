package com.example.kotlinlib.ubt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by ting.fu on 2024/12/18.
 */

fun main() {

    val coroutineScope1 = CoroutineScope(Dispatchers.IO + Job())
    runBlocking {
        coroutineScope1.launch {
            println("TEST BEGIN")

            val a = async() {
                println("a begin Thread= ${Thread.currentThread().name}")
                Thread.sleep(1000)
                println("a end")
                return@async 1
            }

            val b = async() {
                println("b begin Thread= ${Thread.currentThread().name}")
                delay(1000)
                println("b end")
                return@async 2
            }

            val c = async() {
                println("c begin Thread= ${Thread.currentThread().name}")
                val myClass = WaitInit()
                myClass.initialize()
                println("c end")
                return@async 3
            }

            val d = async() {
                println("d begin Thread= ${Thread.currentThread().name}")
                delay(1000)
                println("d end")
                return@async 4
            }


            arrayListOf(
                a,
                b,
                c,
                d
            ).awaitAll()

            println("FINISH.")

        }

        delay(20000)

    }


}