package com.example.kotlinlib.ubt

/**
 * Created by ting.fu on 2024/12/10.
 */



fun main() {

    println(Integer.toBinaryString(15))
    val result = Integer.toBinaryString(9)
    val result1 = Integer.toBinaryString(2)
    println(result)
    println(result1)

//    val status = 8  // 示例值，可以替换成其他整数进行测试
//    val status = 8  // 示例值，可以替换成其他整数进行测试
    val status = 10  // 示例值，可以替换成其他整数进行测试
    checkStatus(status)
}


fun checkStatus(value: Int) {
    println("======")
    println(Integer.toBinaryString(value))
    // 通过位运算判断每个标志位的值
    val headBoardError = (value shr 0) and 1  // 检查 bit 0
    val heatingBoardError = (value shr 1) and 1  // 检查 bit 1
    val powerBoardError = (value shr 2) and 1  // 检查 bit 2
    val pressureSensorError = (value shr 3) and 1  // 检查 bit 3

    // 输出每个主板的异常状态
    println("头部主板异常: ${if (headBoardError == 1) "异常" else "正常"}")
    println("加热主板异常: ${if (heatingBoardError == 1) "异常" else "正常"}")
    println("电源主板异常: ${if (powerBoardError == 1) "异常" else "正常"}")
    println("隐私部位压力传感器异常: ${if (pressureSensorError == 1) "异常" else "正常"}")
}

