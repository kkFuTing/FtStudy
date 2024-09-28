package com.example.kotlinlib.project.modules.login.inter

import com.example.kotlinlib.project.entity.LoginRegisterResponse

// View层  （接口抽象概念）
interface LoginView {

    // 把结果显示到  Activity / Fragment

    fun loginSuccess(loginBean: LoginRegisterResponse ?)

    fun loginFialure(erroeMsg: String  ?)
}