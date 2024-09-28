package com.example.kotlinlib.project.modules.login.inter

import android.content.Context
import com.example.kotlinlib.project.base.IBasePresenter
import com.example.kotlinlib.project.entity.LoginRegisterResponse

// Presenter 层
interface LoginPresenter : IBasePresenter {

    // 登录
    fun loginAction(context: Context, username: String, password: String)

    // 监听回调
    interface OnLoginListener {

        fun loginSuccess(loginBean: LoginRegisterResponse?)

        fun loginFialure(erroeMsg: String  ?)

    }

}