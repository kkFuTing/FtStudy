package com.example.kotlinlib.project.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlib.project.modules.login.inter.LoginPresenter
import java.io.Serializable

/**
 * 同学们这是 “所有Activity的父类”
 */
// public final class

// P extends LoginPresenter                     vs     P: LoginPresenter
//表示IBasePresenter 所有子类都ok
//abstract class BaseActivity<P:IBasePresenter> : AppCompatActivity(){


// P extends LoginPresenter & Serializable      vs     where P : IBasePresenter,  P: Serializable
//abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter, P : Serializable {


abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //让子类去创建
        presenter = createP()

        // 同学们自己去扩展了，可以增加很多的功能
        // 省略 ....
        /*setContentView(getLayoutID())
        initView()
        initData()*/
    }

    abstract fun createP(): P

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    // 类似于工具类函数
    /**
     * 暴漏给自己的孩子   隐藏ActionBar
     */
    fun hideActionBar() {
        // 任何 Java代码东西，必须用 ？ 允许为null，来接收  因为有可能为null 不用？会引起崩溃
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }

    /**
     * 暴漏给自己的孩子   显示ActionBar
     */
    fun showActionBar() {
        supportActionBar?.show()
    }

    // .......  同学们自己去完成

    // TODO 同学们自己去扩展了，可以增加很多的功能
    //  .....
}