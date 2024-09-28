package com.example.kotlinlib.project.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast

// 闭包 + 高阶 + 问题

fun main() {
    Handler(Looper.getMainLooper(), object : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            // 运行就崩溃
            // TODO("Not yet implemented")

            return true
        }
    })

    Handler(Looper.getMainLooper(), Handler.Callback {
        true
    })


    //闭包
    Thread {
        Log.e("", "main: ")
    }.start()

}

fun Context.show(result: String) {
    Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
}