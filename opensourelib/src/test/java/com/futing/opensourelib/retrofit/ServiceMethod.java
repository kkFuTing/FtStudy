package com.futing.opensourelib.retrofit;

import com.futing.opensourelib.retrofit.http.Filed;
import com.futing.opensourelib.retrofit.http.GET;
import com.futing.opensourelib.retrofit.http.POST;
import com.futing.opensourelib.retrofit.http.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * Created by dusuijiang on 2018/10/14.
 */

public class ServiceMethod {

    private String httpMethod; //请求方式
    private String relativeUrl;
    private ParameterHandler[] parameterHandlers; // 处理请求的参数
    private final HttpUrl baseUrl;
    private HttpUrl.Builder builderUrl;
    private  FormBody.Builder formBuilder;
    private final Call.Factory callFactory;

    public ServiceMethod(Builder builder) {
        this.baseUrl = builder.retrofit.baseUrl();
        this.callFactory = builder.retrofit.callFactory();
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.parameterHandlers = builder.parameterHandlers;
    }

    public Call toCall(Object[] args) {
        //1. 创建 request
        Request.Builder requestbuilder = new Request.Builder();
        //1.1 地址
        if (null == builderUrl){
            builderUrl = baseUrl.newBuilder(relativeUrl);
        }

        //1.2 如果时get请求拼接参数
        for (int i = 0; i < parameterHandlers.length; i++) {
            parameterHandlers[i].apply(this, String.valueOf(args[i]));
        }
        FormBody formBody = null;
        if (null != formBuilder){
            formBody = formBuilder.build();
        }

        requestbuilder.url(builderUrl.build());
        Request request = requestbuilder.method(httpMethod,formBody).build();

        //2. 创建Call
        return  callFactory.newCall(request);
    }

    public void addQueryParameter(String name, String value) {
        builderUrl.addQueryParameter(name,value);
    }

    public void addFormFiledParameter(String name, String value) {
        if (formBuilder == null){
            formBuilder = new FormBody.Builder();
        }
        formBuilder.add(name,value);
    }

    public final static class Builder{

        private Annotation[] methodAnnotations;
        private final Annotation[][] parameterAnnotations;
        private  String httpMethod; //请求方式
        private String relativeUrl;
        private ParameterHandler[] parameterHandlers; // 处理请求的参数
        private Retrofit retrofit;
        public Builder(Retrofit retrofit, Method method) {
            this.retrofit = retrofit;
            //获取方法得注解
            methodAnnotations = method.getAnnotations();
            //拿到方法参数的注解
            parameterAnnotations = method.getParameterAnnotations();
        }

        public ServiceMethod build(){

            for (Annotation methodAnnotation : methodAnnotations) {
                //处理方法注解
               parseMethodAnnotation(methodAnnotation);
            }

            //处理参数注解
            parameterHandlers = new ParameterHandler[parameterAnnotations.length];

            //遍历注解参数
            for (int i = 0; i < parameterAnnotations.length; i++) {
                Annotation[] parameterAnnotation = parameterAnnotations[i];
                //遍历一个参数的注解
                for (Annotation annotation : parameterAnnotation) {
                    if (annotation instanceof Query){

                        Query query = ((Query) annotation);
                        String value = query.value();
                        parameterHandlers[i] = new ParameterHandler.Query(value);
                    }else if (annotation instanceof Filed){

                        Filed query = ((Filed) annotation);
                        String value = query.value();
                        parameterHandlers[i] = new ParameterHandler.Filed(value);
                    }
                }
            }

            return new ServiceMethod(this);
        }

        private void parseMethodAnnotation(Annotation methodAnnotation) {
            if (methodAnnotation instanceof GET){
                httpMethod = "GET";
                GET get = (GET) methodAnnotation;
                relativeUrl = get.value();
            }else if (methodAnnotation instanceof POST){
                httpMethod = "POST";
                POST post = (POST) methodAnnotation;
                relativeUrl = post.value();
            }
        }
    }
}
