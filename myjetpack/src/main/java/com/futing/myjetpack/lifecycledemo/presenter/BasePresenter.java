package com.futing.myjetpack.lifecycledemo.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;


import com.futing.myjetpack.lifecycledemo.view.IBaseView;

import java.lang.ref.WeakReference;
//步骤一： 实现LifecycleObserver
public class BasePresenter<T extends IBaseView> implements LifecycleObserver {
    WeakReference<T> iGoodsView;
    /**
     * 绑定view
     */
    public void attachView(T view){
        iGoodsView=new WeakReference<>(view);
    }
    /**
     * 解绑
     */
    public void detachView(){
        if(iGoodsView!=null){
            iGoodsView.clear();
            iGoodsView=null;
        }
    }

    // TODO: 2024/8/24  已经废弃了，先掠过；
//    步骤四： 生命周期的监听，  生命
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreateX(LifecycleOwner owner) {

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStartX(LifecycleOwner owner) {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(LifecycleOwner owner) {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(LifecycleOwner owner) {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(LifecycleOwner owner) {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestory(LifecycleOwner owner) {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner) {
    }
}
