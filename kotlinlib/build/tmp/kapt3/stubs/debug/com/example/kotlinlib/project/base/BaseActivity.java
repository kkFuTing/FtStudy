package com.example.kotlinlib.project.base;

/**
 * 同学们这是 “所有Activity的父类”
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\rH&J\u0006\u0010\u0013\u001a\u00020\rR\u001c\u0010\u0005\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/example/kotlinlib/project/base/BaseActivity;", "P", "Lcom/example/kotlinlib/project/base/IBasePresenter;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "presenter", "getPresenter", "()Lcom/example/kotlinlib/project/base/IBasePresenter;", "setPresenter", "(Lcom/example/kotlinlib/project/base/IBasePresenter;)V", "Lcom/example/kotlinlib/project/base/IBasePresenter;", "createP", "hideActionBar", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "recycle", "showActionBar", "kotlinlib_debug"})
public abstract class BaseActivity<P extends com.example.kotlinlib.project.base.IBasePresenter> extends androidx.appcompat.app.AppCompatActivity {
    public P presenter;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final P getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.NotNull
    P p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract P createP();
    
    public abstract void recycle();
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    /**
     * 暴漏给自己的孩子   隐藏ActionBar
     */
    public final void hideActionBar() {
    }
    
    /**
     * 暴漏给自己的孩子   显示ActionBar
     */
    public final void showActionBar() {
    }
}