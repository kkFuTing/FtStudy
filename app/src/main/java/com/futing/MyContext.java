package com.futing;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

import com.futing.ftstudy.language.MyActivityLifecycleCallbacks;

public class MyContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("MYActivityLifecycle", this + "/" + this + "====" + " onConfigurationChanged" + "==========" + this.getResources().getConfiguration().locale.getLanguage());
    }
}
