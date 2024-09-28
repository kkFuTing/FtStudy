package com.example.kotlinlib.project.modules.register

import android.content.Context
import com.example.kotlinlib.project.api.WanAndroidAPI
import com.example.kotlinlib.project.entity.LoginRegisterResponse
import com.example.kotlinlib.project.modules.register.inter.RegisterModule
import com.example.kotlinlib.project.modules.register.inter.RegisterPersenter
import com.example.kotlinlib.project.net.APIClient
import com.example.kotlinlib.project.net.APIResponse
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterModuleImpl : RegisterModule {

    // 取消请求
    override fun cancelRequest() {}

    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        callback: RegisterPersenter.OnRegisterListener
    ) {
        // 网络模型
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .registerAction(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    callback.registerSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    callback.registerFailed(errorMsg)
                }

            })
    }
}