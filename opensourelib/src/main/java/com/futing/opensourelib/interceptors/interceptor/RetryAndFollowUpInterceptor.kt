package com.futing.opensourelib.interceptors.interceptor;

import com.futing.opensourelib.interceptors.Chain
import com.futing.opensourelib.interceptors.Interceptor

/**
 *  第一个拿到请求
 *  最后一个拿到响应
 */
class RetryAndFollowUpInterceptor : Interceptor {


    override fun intercept(chain: Chain): String {
        //可以在执行下一个拦截器之前，做自己的事情
        println("开始执行重试重定向拦截器");
        // 执行下一个拦截器
        var result = chain.processd(chain.request + "==>经过重试重定向拦截器");
        //获得结果后，加一些自己的东西
        println("结束执行重试重定向拦截器");
        return "$result==>经过重试重定向拦截器";
    }
}
