package com.example.kotlinlib.project.modules.register;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005\u00a8\u0006\u0019"}, d2 = {"Lcom/example/kotlinlib/project/modules/register/RegisterPresenterImpl;", "Lcom/example/kotlinlib/project/modules/register/inter/RegisterPersenter;", "Lcom/example/kotlinlib/project/modules/register/inter/RegisterPersenter$OnRegisterListener;", "view", "Lcom/example/kotlinlib/project/modules/register/inter/RegisterView;", "(Lcom/example/kotlinlib/project/modules/register/inter/RegisterView;)V", "model", "Lcom/example/kotlinlib/project/modules/register/RegisterModuleImpl;", "getView", "()Lcom/example/kotlinlib/project/modules/register/inter/RegisterView;", "setView", "registerFailed", "", "errorMsg", "", "registerSuccess", "registerBean", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponse;", "registerWanAndroid", "context", "Landroid/content/Context;", "username", "password", "repassword", "unAttachView", "kotlinlib_debug"})
public final class RegisterPresenterImpl implements com.example.kotlinlib.project.modules.register.inter.RegisterPersenter, com.example.kotlinlib.project.modules.register.inter.RegisterPersenter.OnRegisterListener {
    @org.jetbrains.annotations.Nullable
    private com.example.kotlinlib.project.modules.register.inter.RegisterView view;
    @org.jetbrains.annotations.NotNull
    private final com.example.kotlinlib.project.modules.register.RegisterModuleImpl model = null;
    
    public RegisterPresenterImpl(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.modules.register.inter.RegisterView view) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.kotlinlib.project.modules.register.inter.RegisterView getView() {
        return null;
    }
    
    public final void setView(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.modules.register.inter.RegisterView p0) {
    }
    
    @java.lang.Override
    public void registerWanAndroid(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    java.lang.String repassword) {
    }
    
    @java.lang.Override
    public void unAttachView() {
    }
    
    @java.lang.Override
    public void registerSuccess(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.entity.LoginRegisterResponse registerBean) {
    }
    
    @java.lang.Override
    public void registerFailed(@org.jetbrains.annotations.Nullable
    java.lang.String errorMsg) {
    }
}