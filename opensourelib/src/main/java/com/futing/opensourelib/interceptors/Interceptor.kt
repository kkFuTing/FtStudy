package com.futing.opensourelib.interceptors;

interface Interceptor {
    fun intercept(chain: Chain): String
}