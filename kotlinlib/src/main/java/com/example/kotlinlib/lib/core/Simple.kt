package com.example.kotlinlib.lib.core
//第三节 收藏模块   1：42开始讲高阶函数；
fun main() {

    // () -> Unit    空参函数  并且 没有返回值  函数名=method01

    // TODO 定义没有问题，调用不行 begin
    var method01: () -> Unit
//    method01() // 不能调用method01  没有具体的实现

    var method02 : (Int, Int) -> Int
//    method02(9, 9) //不能调用method02  没有具体的实现


    var method03: (String, Double) -> Any?
//    method03("Derry", 543354.4) //不能调用method03  没有具体的实现

    var method04: (Int, Double, Long, String?) -> Boolean
//    method04(1, 545, 3543, null) //不能调用method04  没有具体的实现

    var method05: (Int, Int) -> Int
//    method05(9, 9)//不能调用method05  没有具体的实现
// TODO 定义没有问题，调用不行 end

    // TODO: 死记 规则  多敲才有印象！！！
    // : (形参类型)
    // = {具体详情}

    // TODO 定义没有问题，调用OK ，因为有实现了 死记
    var m06: (Int, Int) -> Int = { number1, number2 -> number1 + number2 }
    println("m06:${m06(9, 9)}")

    var m07 = { number1: Int, number2: Int -> number1.toDouble() + number2.toDouble() }
    println("m07:${m07(100, 100)}")

    var m08: (String, String) -> Unit = { aString, bString -> println("a:$aString,  b:$bString") }
    m08("李元霸", "王五")

    //          传参类型     返回参类型   传入的值  返回的值
   // var m09: (String) -> String = { str -> str }
    var m09: (String) -> String = { str -> str }
    println("m09:${m09("降龙十八掌")}")

    //it 是默认的传参映射
    var m10: (Int) -> Unit = {
        when (it) {
            1 -> println("你是一")
            in 20..30 -> println("你是 二十 到 三十")
            else -> println("其他的数字")
        }
    }
    m10(29)

    //传多个就不能用it了 其实等同于m08
    var m11: (Int, Int, Int) -> Unit = { n1, n2, n3 ->
        println("n1:$n1, n2:$n2, n3:$n3")
    }
    m11(29, 22, 33)

    // TODO:  这种我就不习惯啦啦  多看多写多记2024.08.23
//    闭包
    var m12 = { println("我就是m12函数，我就是我") }
    m12()

    //if (sex == 'M') "代表是男的" else "代表是女的"  这是实现
    //sex: Char ->  这是传进来的
    val m13 = { sex: Char -> if (sex == 'M') "代表是男的" else "代表是女的" }
    println("m13:${m13('M')}")

    // 覆盖操作
    var m14 = { number: Int -> println("我就是m14  我的值: $number") }
    m14 = { println("覆盖  我的值: $it") }
    m14(99)

    // 需求：我想打印， 并且，我还想返回值，就是 我什么都想要
    var m15 = { number: Int ->
        println("我想打印: $number")
        number + 1000000
    }
    println("m15:${m15(88)}")

//    TODO有默认值就随便你传不传啦
    method()
    method(9999, 8888)
    method(100000)


    // TODO 先看这个  1

    // TODO  ------------------- 高阶登录需求 --------------------
    loginEngine("Derry2", "123456")

    println("======分割线============")
    loginEngine("Derry", "123456")


//    很多源码就是高阶，例如run{}
    run {}
}


fun method(n1: Int = 9 , n2: Int = 100) {
    println("n1:$n1, n2:$n2")
}


// -------------- 第四节 1：50min左右 高阶
// 对外暴漏
fun loginEngine(userName: String, userPwd: String): Unit {

    // 使用高阶 loginService(userName, userPwd) 后面的  {} 等同于 requestLogin: RequestLogin
    loginService(userName, userPwd) { name, pwd ->
        if (name == "Derry" && pwd == "123456") {
            println("恭喜:${name}登录成功")
        } else {
            println("登录失败，请检查 用户名 或 密码....!!")
        }
    }
}

// 标准  String String --> Unit
typealias RequestLogin = (String, String) -> Unit

//此处的requestLogin: RequestLogin  就是高阶函数  被定义出去了（封装了），也可以写成loginService1 那种函数
private fun loginService(userName: String, userPwd: String, requestLogin: RequestLogin): Unit {
    requestLogin(userName, userPwd)
}

// =========================另一种高阶写法 其实就是改了第三个函数；
//此处 requestLogin1: (String,String)-> Unit   为高阶函数，
private fun loginService1(userName: String, userPwd: String, requestLogin1: (String,String)-> Unit) {
    requestLogin1(userName, userPwd)
}
fun loginEngine1(userName: String, userPwd: String): Unit {

    // 使用高阶  {}
    loginService1(userName, userPwd) { name, pwd ->
        if (name == "Derry" && pwd == "123456") {
            println("恭喜:${name}登录成功")
        } else {
            println("登录失败，请检查 用户名 或 密码....!!")
        }
    }
}