package com.example.kotlinlib.project.modules.login;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/kotlinlib/project/modules/login/LoginActivity;", "Lcom/example/kotlinlib/project/base/BaseActivity;", "Lcom/example/kotlinlib/project/modules/login/inter/LoginPresenter;", "Lcom/example/kotlinlib/project/modules/login/inter/LoginView;", "()V", "binding", "Lcom/example/kotlinlib/databinding/ActivityUserLoginBinding;", "onCLickLister", "Landroid/view/View$OnClickListener;", "createP", "loginFialure", "", "erroeMsg", "", "loginSuccess", "loginBean", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponse;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "recycle", "kotlinlib_debug"})
public final class LoginActivity extends com.example.kotlinlib.project.base.BaseActivity<com.example.kotlinlib.project.modules.login.inter.LoginPresenter> implements com.example.kotlinlib.project.modules.login.inter.LoginView {
    private com.example.kotlinlib.databinding.ActivityUserLoginBinding binding;
    @org.jetbrains.annotations.NotNull
    private final android.view.View.OnClickListener onCLickLister = null;
    
    public LoginActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void loginSuccess(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.entity.LoginRegisterResponse loginBean) {
    }
    
    @java.lang.Override
    public void loginFialure(@org.jetbrains.annotations.Nullable
    java.lang.String erroeMsg) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.kotlinlib.project.modules.login.inter.LoginPresenter createP() {
        return null;
    }
    
    @java.lang.Override
    public void recycle() {
    }
}