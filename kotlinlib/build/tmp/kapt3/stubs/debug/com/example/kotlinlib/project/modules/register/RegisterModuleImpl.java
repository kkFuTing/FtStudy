package com.example.kotlinlib.project.modules.register;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/example/kotlinlib/project/modules/register/RegisterModuleImpl;", "Lcom/example/kotlinlib/project/modules/register/inter/RegisterModule;", "()V", "cancelRequest", "", "register", "context", "Landroid/content/Context;", "username", "", "password", "repassword", "callback", "Lcom/example/kotlinlib/project/modules/register/inter/RegisterPersenter$OnRegisterListener;", "kotlinlib_debug"})
public final class RegisterModuleImpl implements com.example.kotlinlib.project.modules.register.inter.RegisterModule {
    
    public RegisterModuleImpl() {
        super();
    }
    
    @java.lang.Override
    public void cancelRequest() {
    }
    
    @java.lang.Override
    public void register(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    java.lang.String repassword, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.register.inter.RegisterPersenter.OnRegisterListener callback) {
    }
}