package com.futing.opensourelib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiangxue.arouter_annotation.ARouter
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.Request

@ARouter(path = "/opensourelib/MainOkHtpActivity")
class MainOkHtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_okhttp)
        var okHttpClient = OkHttpClient.Builder().build()
        var request = Request.Builder().url("https://www.baidu.com")
            .cacheControl(CacheControl.FORCE_CACHE)
            .build()
        var call = okHttpClient.newCall(request)
        val result = call.execute()
        println(result.isSuccessful)
        result.close()
    }
}