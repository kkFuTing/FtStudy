package com.example.kotlinlib.project.data_model.request;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H&J:\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0012*\u0002H\u00132\u001d\u0010\u0014\u001a\u0019\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u0015\u00a2\u0006\u0002\b\u0016\u00a2\u0006\u0002\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/example/kotlinlib/project/data_model/request/NetworkResultData;", "Lokhttp3/Callback;", "()V", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "reqeustSuccess", "result", "requestError", "info", "", "myLet", "R", "T", "mm", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinlib_debug"})
public abstract class NetworkResultData implements okhttp3.Callback {
    
    public NetworkResultData() {
        super();
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.NotNull
    okhttp3.Call call, @org.jetbrains.annotations.NotNull
    java.io.IOException e) {
    }
    
    @java.lang.Override
    public void onResponse(@org.jetbrains.annotations.NotNull
    okhttp3.Call call, @org.jetbrains.annotations.NotNull
    okhttp3.Response response) {
    }
    
    public abstract void requestError(@org.jetbrains.annotations.NotNull
    java.lang.String info);
    
    public abstract void reqeustSuccess(@org.jetbrains.annotations.NotNull
    okhttp3.Response result);
    
    public final <T extends java.lang.Object, R extends java.lang.Object>R myLet(T $this$myLet, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super T, ? super T, ? extends R> mm) {
        return null;
    }
}