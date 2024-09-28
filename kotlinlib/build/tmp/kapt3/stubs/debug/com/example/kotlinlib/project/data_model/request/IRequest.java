package com.example.kotlinlib.project.data_model.request;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/example/kotlinlib/project/data_model/request/IRequest;", "", "instanceRequestAction", "", "url", "", "value", "resultData", "Lcom/example/kotlinlib/project/data_model/request/NetworkResultData;", "value1", "value2", "value3", "kotlinlib_debug"})
public abstract interface IRequest {
    
    /**
     * TODO ********************** 下面这一系列都是 NetWork相关的
     */
    public abstract void instanceRequestAction(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.data_model.request.NetworkResultData resultData);
    
    public abstract void instanceRequestAction(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String value1, @org.jetbrains.annotations.NotNull
    java.lang.String value2, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.data_model.request.NetworkResultData resultData);
    
    public abstract void instanceRequestAction(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String value1, @org.jetbrains.annotations.NotNull
    java.lang.String value2, @org.jetbrains.annotations.NotNull
    java.lang.String value3, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.data_model.request.NetworkResultData resultData);
}