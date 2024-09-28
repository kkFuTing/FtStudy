package com.futing.uiapplication.skin;

import android.app.Application;

import com.futing.uiapplication.skinlib.SkinManager;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.init(this);
    }
}
