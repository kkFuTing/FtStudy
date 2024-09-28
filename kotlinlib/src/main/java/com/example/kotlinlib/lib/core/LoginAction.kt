// TODO 2

package com.example.kotlinlib.lib.core

fun main() {
    // 用户
    // 再次模拟登录流程
//    login("Derry1", "123456")//这样调用不了啦
    login("Derry1", "123456") {
        println(it)
    }
    println("==================")
    //
    // {if (it) println("最终得到的结果是 登录成功") else println("最终得到的结果是 登录失败") } 为高阶响应体
    loginEngine("Derry", "123456") {
        if (it) println("最终得到的结果是 登录成功") else println("最终得到的结果是 登录失败")
    }
    println("==================")
    // 有返回值  此处 { true }为高阶的实现区域 等于 mm: () -> Boolean 误差返回Boolean
     // TODO: 2024.08.23 这个例子太难看懂了 ！！！！！  高阶函数的实现
    val r = loginTest() {
        true
    }

    println("方法的结果：${r}")
}

fun loginTest(mm: () -> Boolean): Int {
    val result = mm()
    println("result:$result")

    return 99999
}


//login 为高阶函数  关键是   responseResult: (Boolean) -> Unit
public fun login(userName: String, userPwd: String, responseResult: (Boolean) -> Unit) {
    loginEngine(userName, userPwd, responseResult)
}

// 内部去完成登录功能
private fun loginEngine(userName: String, userPwd: String, responseResult: (Boolean) -> Unit) {
    val DB_USER_NAME = "Derry"
    val DB_USER_PWD = "123456"

    if (userName == DB_USER_NAME && userPwd == DB_USER_PWD) {
        // TODO 模拟做了很多业务逻辑
        //  ......
        responseResult(true)
    } else {
        // TODO 模拟做了很多业务逻辑
        //  ......
        responseResult(false)
    }
}


