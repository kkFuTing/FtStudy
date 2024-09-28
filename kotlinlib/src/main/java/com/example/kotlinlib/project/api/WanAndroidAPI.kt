package com.example.kotlinlib.project.api

import com.example.kotlinlib.project.entity.LoginRegisterResponse
import com.example.kotlinlib.project.entity.LoginRegisterResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// 客户端API 可以访问 服务器的API
interface WanAndroidAPI {

    /**
     * 登录API
     * username=Derry-vip&password=123456
     */
    @POST("/user/login")
    @FormUrlEncoded // 表达注解的意思
    fun loginAction(@Field("username") username: String,
                    @Field("password") password: String)
    : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>> // 返回值

    /**
     * 注册的API
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerAction(@Field("username") username: String,
                       @Field("password") password: String,
                       @Field("repassword") repassword: String)
            : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>> // 返回值
}