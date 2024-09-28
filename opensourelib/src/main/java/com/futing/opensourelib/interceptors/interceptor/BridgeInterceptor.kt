package com.futing.opensourelib.interceptors.interceptor;

import com.futing.opensourelib.interceptors.Chain
import com.futing.opensourelib.interceptors.Interceptor

class BridgeInterceptor : Interceptor {
    override fun intercept(chain: Chain): String {
        println("开始执行桥接拦截器")
        var result = chain.processd(chain.request + "==>经过桥接拦截器");
        println("结束执行桥接拦截器")
        return "$result==>经过桥接拦截器";
    }

}
