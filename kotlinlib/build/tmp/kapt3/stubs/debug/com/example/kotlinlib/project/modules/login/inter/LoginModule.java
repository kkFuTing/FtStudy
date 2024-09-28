package com.example.kotlinlib.project.modules.login.inter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/example/kotlinlib/project/modules/login/inter/LoginModule;", "", "cancelRequest", "", "login", "context", "Landroid/content/Context;", "username", "", "password", "onLoginListener", "Lcom/example/kotlinlib/project/modules/login/inter/LoginPresenter$OnLoginListener;", "kotlinlib_debug"})
public abstract interface LoginModule {
    
    public abstract void cancelRequest();
    
    public abstract void login(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.login.inter.LoginPresenter.OnLoginListener onLoginListener);
}