package com.futing.opensourelib.retrofit;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * Created by dusuijiang on 2018/10/14.
 */

public class Retrofit {

    private final HttpUrl baseUrl;
    private final Call.Factory callFactory;

    private Map<Method,ServiceMethod> serviceMethodCache = new HashMap<>();
    public Retrofit(Builder builder) {
        baseUrl = builder.baseUrl;
        callFactory = builder.callFactory;
    }

    public HttpUrl baseUrl() {
        return baseUrl;
    }

    public Call.Factory callFactory() {
        return callFactory;
    }

    public<T> T create(Class<T> clazz){
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //实现网络请求
                //采集数据
                ServiceMethod serviceMethod = loadServiceMethod(method);
                Call call = serviceMethod.toCall(args);
                return call;
            }
        });
    }


    private ServiceMethod loadServiceMethod(Method method){

        ServiceMethod serviceMethod = serviceMethodCache.get(method);


        if (serviceMethod == null){
            serviceMethod = new ServiceMethod.Builder(this,method).build();
            serviceMethodCache.putIfAbsent(method,serviceMethod);
        }

        return serviceMethod;
    }
    public static final class Builder{

        private HttpUrl baseUrl;
        private Call.Factory callFactory;

        public Builder baseUrl(String baseUrl){
            this.baseUrl = HttpUrl.parse(baseUrl);
            return this;
        }

        public Builder callFactory(Call.Factory callFactory){
            this.callFactory = callFactory;
            return this;
        }

        public Retrofit build(){
            if (null == baseUrl){
                throw  new IllegalArgumentException("BaseUrl not set");
            }

            if (null == callFactory){
                callFactory = new OkHttpClient();
            }

            return new Retrofit(this);

        }
    }
}
