package com.futing.opensourelib.interceptors.interceptor;

import com.futing.opensourelib.interceptors.Chain
import com.futing.opensourelib.interceptors.Interceptor

class CallServerInterceptor : Interceptor {


    override fun intercept(chain: Chain): String {
        println("开始执行请求服务器拦截器");
        println("===发起请求===");
        println("结束执行请求服务器拦截器");
        return chain.request + "==>经过请求服务器拦截器\nHttp响应==>经过请求服务器拦截器";
    }
}