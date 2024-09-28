package com.example.kotlinlib.project.modules.login;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005\u00a8\u0006\u0018"}, d2 = {"Lcom/example/kotlinlib/project/modules/login/LoginPresenterImpl;", "Lcom/example/kotlinlib/project/modules/login/inter/LoginPresenter;", "Lcom/example/kotlinlib/project/modules/login/inter/LoginPresenter$OnLoginListener;", "loginView", "Lcom/example/kotlinlib/project/modules/login/inter/LoginView;", "(Lcom/example/kotlinlib/project/modules/login/inter/LoginView;)V", "loginModel", "Lcom/example/kotlinlib/project/modules/login/LoginModelImpl;", "getLoginView", "()Lcom/example/kotlinlib/project/modules/login/inter/LoginView;", "setLoginView", "loginAction", "", "context", "Landroid/content/Context;", "username", "", "password", "loginFialure", "erroeMsg", "loginSuccess", "loginBean", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponse;", "unAttachView", "kotlinlib_debug"})
public final class LoginPresenterImpl implements com.example.kotlinlib.project.modules.login.inter.LoginPresenter, com.example.kotlinlib.project.modules.login.inter.LoginPresenter.OnLoginListener {
    @org.jetbrains.annotations.Nullable
    private com.example.kotlinlib.project.modules.login.inter.LoginView loginView;
    @org.jetbrains.annotations.NotNull
    private final com.example.kotlinlib.project.modules.login.LoginModelImpl loginModel = null;
    
    public LoginPresenterImpl(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.modules.login.inter.LoginView loginView) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.kotlinlib.project.modules.login.inter.LoginView getLoginView() {
        return null;
    }
    
    public final void setLoginView(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.modules.login.inter.LoginView p0) {
    }
    
    @java.lang.Override
    public void loginAction(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    @java.lang.Override
    public void unAttachView() {
    }
    
    @java.lang.Override
    public void loginSuccess(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.entity.LoginRegisterResponse loginBean) {
    }
    
    @java.lang.Override
    public void loginFialure(@org.jetbrains.annotations.Nullable
    java.lang.String erroeMsg) {
    }
}