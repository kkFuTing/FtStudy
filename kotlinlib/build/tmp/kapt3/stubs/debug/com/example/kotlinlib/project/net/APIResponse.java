package com.example.kotlinlib.project.net;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0017\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/kotlinlib/project/net/APIResponse;", "T", "Lio/reactivex/Observer;", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponseWrapper;", "context", "Landroid/content/Context;", "isShow", "", "(Landroid/content/Context;Z)V", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "failure", "", "errorMsg", "", "onComplete", "onError", "e", "", "onNext", "t", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "success", "data", "(Ljava/lang/Object;)V", "kotlinlib_debug"})
public abstract class APIResponse<T extends java.lang.Object> implements io.reactivex.Observer<com.example.kotlinlib.project.entity.LoginRegisterResponseWrapper<T>> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private boolean isShow = true;
    
    public APIResponse(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public APIResponse(@org.jetbrains.annotations.NotNull
    android.content.Context context, boolean isShow) {
        super();
    }
    
    public abstract void success(@org.jetbrains.annotations.Nullable
    T data);
    
    public abstract void failure(@org.jetbrains.annotations.Nullable
    java.lang.String errorMsg);
    
    @java.lang.Override
    public void onSubscribe(@org.jetbrains.annotations.NotNull
    io.reactivex.disposables.Disposable d) {
    }
    
    @java.lang.Override
    public void onNext(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.entity.LoginRegisterResponseWrapper<T> t) {
    }
    
    @java.lang.Override
    public void onError(@org.jetbrains.annotations.NotNull
    java.lang.Throwable e) {
    }
    
    @java.lang.Override
    public void onComplete() {
    }
}