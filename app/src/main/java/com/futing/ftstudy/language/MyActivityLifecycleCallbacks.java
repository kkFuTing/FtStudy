package com.futing.ftstudy.language;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.futing.MyContext;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyActivityLifecycleCallbacks implements MyContext.ActivityLifecycleCallbacks {
    ArrayList<Activity> mAllActiveActivityList = new ArrayList<Activity>();

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " created" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
//        mAllActiveActivityList.add(activity);
        // 在 Activity 创建时，添加配置变化监听器
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " started" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " resumed" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " paused" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " stopped" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }

    @Override
    public void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
//        Application.ActivityLifecycleCallbacks.super.onActivityPostSaveInstanceState(activity, outState);
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " onActivityPostSaveInstanceState" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }

    @Override
    public void onActivityPreSaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " onActivityPreSaveInstanceState" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " saveInstanceState" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        mAllActiveActivityList.remove(activity);
        Log.d("MYActivityLifecycle", activity.getLocalClassName() + "/" + activity + "====" + " destroyed" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
    }


    public void onConfigurationChanged() {
        for (int i = 0; i < mAllActiveActivityList.size(); i++) {
            Activity activity = mAllActiveActivityList.get(i);
            if (activity != null) {
                Log.d("MYActivityLifecycle", i+"/"+mAllActiveActivityList.size()+"::"+activity.getLocalClassName() + "/" + activity + "====" + " destroyed" + "==========" + activity.getResources().getConfiguration().locale.getLanguage());
            }
        }
    }
}
