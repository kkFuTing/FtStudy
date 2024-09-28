package com.xiangxue.xc

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlinlib.R
import com.example.kotlinlib.databinding.ActivityMainXcBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainXcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main_xc)
        binding = ActivityMainXcBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun click1(view: View) = runBlocking { // 外协程
        // 协程环境了  默认是：main线程
        launch(Dispatchers.IO) { // 内协程
            Log.e("click1: ", "launch ${Thread.currentThread().name}")

            //轮询十次
            repeat(10) {
                Thread.sleep(1000)
                Log.e("click1: ", "计数中: ${it}当前处于${Thread.currentThread().name}")
            }
        }
    }

    fun click2(view: View) = runBlocking {
        // 不使用协程
        // displayMethod(textView)

        // 使用协程
        displayMethodOk(binding.textView)
    }


    fun click3(view: View) = runBlocking {
        // TODO 完成这种  异步线程  和  主线程  的切换，  这个需求：之前我们用RxJava实现过了哦
        // 1.注册耗时操作
        // 2.注册耗时操作完成后，更新注册UI
        // 3.登录耗时操作
        // 4.登录耗时操作完成后，更新登录UI

        // main
        launch {
            val pro = ProgressDialog(this@MainActivity)
            pro.setMessage("正在执行中...")
            pro.show() //执行完下面的 才弹出来 不懂为什么。放在外面执行下面完之前也不能弹出来

// todo           withContext 不知道和 前面的 async有什么区别 2024.08.24
//            withContext 阻塞式
            withContext(Dispatchers.IO) {
                // 1.注册耗时操作  异步
                Log.d("click3", "1.注册耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(2000)
            }

            // 2.注册耗时操作完成后，更新注册UI  main
            Log.d("click3", "2.注册耗时操作完成后，更新注册UI: ${Thread.currentThread().name}")

            withContext(Dispatchers.IO) {
                // 3.登录耗时操作  异步
                Log.d("click3", "3.登录耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(3000)
            }

            // 4.登录耗时操作完成后，更新登录UI
            Log.d("click3", "4.登录耗时操作完成后，更新登录UI: ${Thread.currentThread().name}")

//             pro.dismiss()
        }

    }

    // 非阻塞
    fun click4(view: View) {
        // TODO 完成这种  异步线程  和  主线程  的切换，  这个需求：之前我们用RxJava实现过了哦
        // 1.注册耗时操作
        // 2.注册耗时操作完成后，更新注册UI
        // 3.登录耗时操作
        // 4.登录耗时操作完成后，更新登录UI

        // main
        GlobalScope.launch(Dispatchers.Main) {

            val pro = ProgressDialog(this@MainActivity)
            pro.setMessage("正在执行中...")
            pro.show()

            withContext(Dispatchers.IO) {
                // 1.注册耗时操作  异步
                Log.d("click3", "1.注册耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(2000)
            }

            // 2.注册耗时操作完成后，更新注册UI  main
            Log.d("click3", "2.注册耗时操作完成后，更新注册UI: ${Thread.currentThread().name}")
            binding.textView.text = "注册成功，你可以去登录了"
            pro.setMessage(binding.textView.text.toString())

            withContext(Dispatchers.IO) {
                // 3.登录耗时操作  异步
                Log.d("click3", "3.登录耗时操作: ${Thread.currentThread().name}")
                Thread.sleep(3000)
            }

            // 4.登录耗时操作完成后，更新登录UI
            Log.d("click3", "4.登录耗时操作完成后，更新登录UI: ${Thread.currentThread().name}")
            binding.textView.text = "登录成功，欢迎回来"
            pro.setMessage(binding.textView.text.toString())

            pro.dismiss()
        }

    }
}
