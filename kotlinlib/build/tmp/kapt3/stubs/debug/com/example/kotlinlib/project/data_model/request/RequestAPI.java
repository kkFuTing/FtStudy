package com.example.kotlinlib.project.data_model.request;

/**
 * request 是以okhttp的申请的网络模型；
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n\"\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J0\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/example/kotlinlib/project/data_model/request/RequestAPI;", "Lcom/example/kotlinlib/project/data_model/request/IRequest;", "()V", "commonOKHttpRequestAction", "", "url", "", "resultData", "Lcom/example/kotlinlib/project/data_model/request/NetworkResultData;", "values", "", "(Ljava/lang/String;Lcom/example/kotlinlib/project/data_model/request/NetworkResultData;[Ljava/lang/String;)V", "instanceRequestAction", "value", "value1", "value2", "value3", "kotlinlib_debug"})
public final class RequestAPI implements com.example.kotlinlib.project.data_model.request.IRequest {
    @org.jetbrains.annotations.NotNull
    public static final com.example.kotlinlib.project.data_model.request.RequestAPI INSTANCE = null;
    
    private RequestAPI() {
        super();
    }
    
    @java.lang.Override
    public void instanceRequestAction(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.data_model.request.NetworkResultData resultData) {
    }
    
    @java.lang.Override
    public void instanceRequestAction(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String value1, @org.jetbrains.annotations.NotNull
    java.lang.String value2, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.data_model.request.NetworkResultData resultData) {
    }
    
    @java.lang.Override
    public void instanceRequestAction(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String value1, @org.jetbrains.annotations.NotNull
    java.lang.String value2, @org.jetbrains.annotations.NotNull
    java.lang.String value3, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.data_model.request.NetworkResultData resultData) {
    }
    
    /**
     * TODO ********************** 下面这一系列都是 OKHTTP 执行请求逻辑相关的
     */
    private final void commonOKHttpRequestAction(java.lang.String url, com.example.kotlinlib.project.data_model.request.NetworkResultData resultData, java.lang.String... values) {
    }
}