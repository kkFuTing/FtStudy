package com.example.kotlinlib.project.modules.register

import android.content.Context
import com.example.kotlinlib.project.entity.LoginRegisterResponse
import com.example.kotlinlib.project.modules.register.inter.RegisterPersenter
import com.example.kotlinlib.project.modules.register.inter.RegisterView

class RegisterPresenterImpl constructor(var view: RegisterView ?) : RegisterPersenter
, RegisterPersenter.OnRegisterListener

{

    // 需要  M 去请求 拿业务数据         搞定
    private val model = RegisterModuleImpl()

    // 需要 V 拿到响应数据后   给 UI     搞定

    override fun registerWanAndroid(
        context: Context,
        username: String,
        password: String,
        repassword: String
    ) {
        // TODO
        // 可以做很多的事情
        // 可以省略很多代码
        // 很多的校验
        // ....

        model.register(context, username, password, repassword, this)
    }

    override fun unAttachView() {
        view = null
        model.cancelRequest()
    }

    // 响应的数据
    override fun registerSuccess(registerBean: LoginRegisterResponse?) {
        // TODO
        // 可以做很多的事情
        // 可以省略很多代码
        // 很多的校验
        // ....

        view?.registerSuccess(registerBean)
    }

    override fun registerFailed(errorMsg: String?) {
        // TODO
        // 可以做很多的事情
        // 可以省略很多代码
        // 很多的校验
        // ....

        view?.registerFailed(errorMsg)
    }


}