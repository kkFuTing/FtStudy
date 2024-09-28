package com.example.kotlinlib.project.modules.login.inter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/kotlinlib/project/modules/login/inter/LoginView;", "", "loginFialure", "", "erroeMsg", "", "loginSuccess", "loginBean", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponse;", "kotlinlib_debug"})
public abstract interface LoginView {
    
    public abstract void loginSuccess(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.entity.LoginRegisterResponse loginBean);
    
    public abstract void loginFialure(@org.jetbrains.annotations.Nullable
    java.lang.String erroeMsg);
}