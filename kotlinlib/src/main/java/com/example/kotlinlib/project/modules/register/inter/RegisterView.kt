package com.example.kotlinlib.project.modules.register.inter

import com.example.kotlinlib.project.entity.LoginRegisterResponse

interface RegisterView {

    // 成功 失败 显示 到 Activty

    fun registerSuccess(registerBean: LoginRegisterResponse?)

    fun registerFailed(errorMsg: String?)


}