package com.example.kotlinlib.project.modules.register.inter

import android.content.Context
import com.example.kotlinlib.project.base.IBasePresenter
import com.example.kotlinlib.project.entity.LoginRegisterResponse

interface RegisterPersenter : IBasePresenter {

    fun registerWanAndroid(context: Context, username: String, password: String, repassword: String)

    // M  ---》 P  接口监听
    interface OnRegisterListener {

        fun registerSuccess(registerBean: LoginRegisterResponse?)

        fun registerFailed(errorMsg: String?)

    }

}