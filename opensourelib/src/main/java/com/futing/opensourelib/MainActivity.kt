package com.futing.opensourelib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.futing.opensourelib.eventbus.Main5Activity
import com.futing.opensourelib.glide.Glide
import com.futing.opensourelib.rxjava.rx.RxActivity
import com.futing.opensourelib.rxjava.source.RxJavaThreadSource1
import com.futing.opensourelib.rxjava.source.RxJavaThreadSource2
import com.futing.opensourelib.rxjava.source1.SourceActivity1
import com.futing.opensourelib.rxjava.source1.SourceActivity2
import com.xiangxue.arouter_annotation.ARouter

// Fresco  LoadImage  框架  看起来非常舒服   Git

// Glide 开了一周Glide 源码，找不到 网络请求的地方  研究了半年才能给大家说出一点东西
// Git  视频第一帧  功能性

// RxJava  OkHtt

/**
 * 想问一下，当在activity onResume的时候,页面控件点击执行glide加载图片的时候,此时activity走的函数已经到了onResume,此时加入的空白Fragment的onCreate如何跟activity同步呢？如何触发Fragment的onCreate监听呢？
 */
@ARouter(path = "/opensourelib/MainActivity")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_opensuorce)

        Glide.with(this)
    }

    override fun onStart() {
        super.onStart()
    }

    fun btRxJavaOnclick(view: View) {
        startActivity(Intent(this, RxJavaThreadSource1::class.java))
    }

    fun btRxJava2OnClick(view: View) {
        startActivity(Intent(this, RxJavaThreadSource2::class.java))
    }

    fun btRxJava3OnClick(view: View) {
        startActivity(Intent(this, RxActivity::class.java))
    }

    fun btRxJava4OnClick(view: View) {
        startActivity(Intent(this, SourceActivity2::class.java))
    }

    fun btRxJava5OnClick(view: View) {
        startActivity(Intent(this, SourceActivity1::class.java))
    }

    fun btEventbusOnClick(view: View) {
        startActivity(Intent(this, Main5Activity::class.java))
    }
}