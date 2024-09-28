package com.example.kotlinlib

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        mains()
    }

    fun mains() {
        val r1: Int = "Derry".run {
            1
        }
        println(r1)
    }

    @Test
    fun let() {
        val result = "futting".let {
            true
        }
        println(result)

        val result1 = "futing".let {
            true
            it.length
        }
        println(result1)

        val let = 123.let {
            999
            "【${it}】"
        }

        println(let)
    }


    // TODO: 泛型形变 ：不变，形变，协变
//    不变
    class StudentSetGets<IO> {
        private var intem: IO? = null

        //消费者
        fun set(value: IO) {
            println("你传递进来的内容：$value")
        }

        //生产者
        fun get() = intem

    }

    //协变 只能是生产者
    class StudentGet<out T>(_item: T) {
        private val item = _item
        fun get(): T = item
    }

    //逆变 只能是消费者
    class StudentSet<in T>() {
        fun set(value: T) = println("你传进来的内容是：$value")
    }


}

