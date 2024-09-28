package com.futing.opensourelib.interceptors;

import com.futing.opensourelib.interceptors.interceptor.*
import com.futing.opensourelib.interceptors.interceptor.BridgeInterceptor

/**
 * 第四期
 * okhttp 的设计思想，拦截器
 */

fun main(args: Array<String>) {
    var interceptors = ArrayList<Interceptor>()
    interceptors.add(RetryAndFollowUpInterceptor())
    interceptors.add(BridgeInterceptor())
    interceptors.add(CacheInterceptor())
    interceptors.add(ConnectInterceptor())
    interceptors.add(CallServerInterceptor())

    //链条对象
    var chain = Chain(interceptors, 0);
    System.out.println(chain.processd("Http请求"));
}