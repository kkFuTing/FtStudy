package com.example.kotlinlib.lib.kt.s05

fun main() {
    //此处的调用的 {} 等于     loginMethod:(Boolean)->Char
//    show(true) {
////         println(it)
//        'M'
//    }

    show1(true) {
         println("SHOW FT$it")
    }
}

// TODO  loginMethod:(Boolean)->Unit

fun loginMethod(b: Boolean) : Unit {

}




// loginMethod 方法名
// (Boolean)方法的那个括号 传了Boolean类型
// -> 方法体 干活
// Unit == void

//高阶函数 ,把第二个参数当作一个函数；
fun show(isLogin: Boolean, loginMethod:(Boolean)->Char) {
    if (isLogin) {
        println("登录成功")
        val r = loginMethod(true)
        println(r)
    } else {
        println("登录失败")
        loginMethod(false)
    }
}


fun show1(isLogin: Boolean, loginMethod:(Boolean)->Unit) {
    if (isLogin) {
        println("登录成功")
        val r = loginMethod(true)
        println(r)
    } else {
        println("登录失败")
        loginMethod(false)
    }
}