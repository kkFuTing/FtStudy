package com.example.kotlinlib.interview

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Initializer {

    fun initialize(callback: (Boolean) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = doInit() // 执行初始化逻辑
            withContext(Dispatchers.Main) {
                callback(result) // 返回结果
            }
        }
    }

    private suspend fun doInit(): Boolean {
        // 模拟延迟
        delay(2000) // 示例延迟
        return true // 返回结果
    }
}
