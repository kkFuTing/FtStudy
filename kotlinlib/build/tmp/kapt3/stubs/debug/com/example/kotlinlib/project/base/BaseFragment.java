package com.example.kotlinlib.project.base;

/**
 * 同学们这是 “所有Fragment的父类“
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH&J\r\u0010\u000f\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH&J\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/example/kotlinlib/project/base/BaseFragment;", "P", "Lcom/example/kotlinlib/project/base/IBasePresenter;", "Landroidx/fragment/app/Fragment;", "()V", "mActivity", "Landroidx/appcompat/app/AppCompatActivity;", "p", "getP", "()Lcom/example/kotlinlib/project/base/IBasePresenter;", "setP", "(Lcom/example/kotlinlib/project/base/IBasePresenter;)V", "Lcom/example/kotlinlib/project/base/IBasePresenter;", "createOK", "", "getPresenter", "hideActionBar", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onDestroy", "recycle", "showActionBar", "kotlinlib_debug"})
public abstract class BaseFragment<P extends com.example.kotlinlib.project.base.IBasePresenter> extends androidx.fragment.app.Fragment {
    public P p;
    private androidx.appcompat.app.AppCompatActivity mActivity;
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final P getP() {
        return null;
    }
    
    public final void setP(@org.jetbrains.annotations.NotNull
    P p0) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onActivityCreated(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract P getPresenter();
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    public abstract void createOK();
    
    public abstract void recycle();
    
    /**
     * 暴露给自己的孩子 隐藏ActionBar
     */
    public final void hideActionBar() {
    }
    
    /**
     * 暴露给自己的孩子 显示ActionBar
     */
    public final void showActionBar() {
    }
}