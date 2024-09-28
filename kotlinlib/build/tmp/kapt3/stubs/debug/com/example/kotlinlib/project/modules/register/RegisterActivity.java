package com.example.kotlinlib.project.modules.register;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/kotlinlib/project/modules/register/RegisterActivity;", "Lcom/example/kotlinlib/project/base/BaseActivity;", "Lcom/example/kotlinlib/project/modules/register/inter/RegisterPersenter;", "Lcom/example/kotlinlib/project/modules/register/inter/RegisterView;", "()V", "binding", "Lcom/example/kotlinlib/databinding/ActivityUserRegisterBinding;", "createP", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "recycle", "registerFailed", "errorMsg", "", "registerSuccess", "registerBean", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponse;", "kotlinlib_debug"})
public final class RegisterActivity extends com.example.kotlinlib.project.base.BaseActivity<com.example.kotlinlib.project.modules.register.inter.RegisterPersenter> implements com.example.kotlinlib.project.modules.register.inter.RegisterView {
    private com.example.kotlinlib.databinding.ActivityUserRegisterBinding binding;
    
    public RegisterActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.kotlinlib.project.modules.register.inter.RegisterPersenter createP() {
        return null;
    }
    
    @java.lang.Override
    public void recycle() {
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