package com.example.kotlinlib.lib.core_update

import com.example.kotlinlib.lib.kt.s01.show

fun main() {
    //写法1：
    show1("Derry") {
        println("输出：$it")
    }

    //写法2：写法等同于上面
    show1("李元霸", mm = {
        println("输出2：$it")
    })

    //写法3：
    show1("雄霸", {
        println("输出3：$it")
    })

    //写法4： 因为默认值可以不用传参
    show1 {
        println("输出4： $it")
    }

    println("run 函数=====")
    //写法1： 多看把，这里不知道为什么不传可以 说是一个参数可以默认activity 高阶函数的实现；
    sun1 {
        println("输出5：$it")
    }

    sun1({
        println("输出6：$it")
    })

    // 一个参数的话，就是默认的it
    sun1({
    })

    // 两个参数的话，就没法默认it，就需要手动指定
    sun2({ n1, b2 ->

    })


    /**
         sun1({
         })

          sun2({

          })
     */
}

fun show1(name:String = "李连杰", mm: (String) -> Unit) {
    mm(name)
}

fun sun1(mm: (Int) -> Unit) {
    mm(9)
}

fun sun2(mm: (Int, Boolean) -> Unit) {
    mm(9, true)
}