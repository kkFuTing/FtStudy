package com.futing.myjetpack.workmanagersimple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * 后台任务4
 */
public class MainWorker4 extends Worker {

    public final static String TAG = MainWorker4.class.getSimpleName();

    private Context mContext;
    private WorkerParameters workerParams;

    // 有构造函数
    public MainWorker4(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.mContext = context;
        this.workerParams = workerParams;
    }

    @SuppressLint("RestrictedApi")
    @NonNull
    @Override
    public Result doWork() {

        Log.d(TAG, "MainWorker4 doWork: 后台任务执行了");

        return new Result.Success(); // 本地执行 doWork 任务时 成功 执行任务完毕
    }
}
