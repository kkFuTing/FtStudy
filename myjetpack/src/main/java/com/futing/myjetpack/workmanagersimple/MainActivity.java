package com.futing.myjetpack.workmanagersimple;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.futing.myjetpack.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// TODO: 2024/8/25 监听文件的变化 SharedPreferences.OnSharedPreferenceChangeListener
public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private Button bt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_workmanager);
        bt6 = findViewById(R.id.bt6);

        // 绑定监听
        SharedPreferences sp = getSharedPreferences(MainWorker7.SP_NAME, Context.MODE_PRIVATE);
        sp.registerOnSharedPreferenceChangeListener(this); // 给SP绑定监听
        updateToUI(); // 第一次初始化一把
    }

    /**
     * 最简单的 执行任务
     * 测试后台任务 1
     * @param view
     */
    public void testBackgroundWork1(View view) {

        // TODO: 2024/8/25 看到class 想不都不用想都是用反射
        OneTimeWorkRequest oneTimeWorkRequest =
                new OneTimeWorkRequest.Builder(MainWorker1.class).build();

        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
    }

    /**
     * 数据 互相传递
     * 测试后台任务 2
     *
     * @param view
     */
    public void testBackgroundWork2(View view) {
        // 单一的任务  一次
        OneTimeWorkRequest oneTimeWorkRequest1;

        // 数据 //将sendData数据传过去
        Data sendData = new Data.Builder().putString("Derry", "九阳神功").build();

        // 请求对象初始化
        oneTimeWorkRequest1 = new OneTimeWorkRequest.Builder(MainWorker2.class)
                .setInputData(sendData) // 数据的携带
                .build();


        // 想接收 任务回馈的数据，需要状态机  LiveData(老师讲过 如果没有学过 观察者设计模式)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest1.getId())
                .observe(this, workInfo -> {

                    Log.d(MainWorker2.TAG, "状态：" + workInfo.getState().name());
                    if (workInfo.getState().isFinished()) {

                        // 知道 本次任务执行的时候 各种状态  （SUCCEEDED，isFinished=true， 我再接收 任何回馈给我的数据）
                        // 状态机 成功的时候 才去打印
                        Log.d(MainWorker2.TAG, "Activity取到了任务回传的数据: " + workInfo.getOutputData().getString("Derry"));

                        Log.d(MainWorker2.TAG, "状态：isFinished=true 同学们注意：后台任务已经完成了...");
                    }
                });


        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest1);
    }

    /**
     * 多个任务 顺序执行
     * 测试后台任务 3
     * @param view
     */
    public void testBackgroundWork3(View view) {
        // 单一的任务  一次
        OneTimeWorkRequest oneTimeWorkRequest3 = new OneTimeWorkRequest.Builder(MainWorker3.class).build();
        OneTimeWorkRequest oneTimeWorkRequest4 = new OneTimeWorkRequest.Builder(MainWorker4.class).build();
        OneTimeWorkRequest oneTimeWorkRequest5 = new OneTimeWorkRequest.Builder(MainWorker5.class).build();
        OneTimeWorkRequest oneTimeWorkRequest6 = new OneTimeWorkRequest.Builder(MainWorker6.class).build();

        // 顺序执行 3 4 5 6
        WorkManager.getInstance(this)
                .beginWith(oneTimeWorkRequest3)  // 检查的任务
                .then(oneTimeWorkRequest4) // 业务1任务
                .then(oneTimeWorkRequest5) // 业务2任务
                .then(oneTimeWorkRequest6) // 最后检查工作任务
                .enqueue();

        // 需求：先执行  3  4    最后执行 6
        List<OneTimeWorkRequest> oneTimeWorkRequests = new ArrayList<>();
        oneTimeWorkRequests.add(oneTimeWorkRequest3); // 先同步日志信息
        oneTimeWorkRequests.add(oneTimeWorkRequest4); // 先更新服务器数据信息

        WorkManager.getInstance(this).beginWith(oneTimeWorkRequests)
                .then(oneTimeWorkRequest6) // 最后再 检查同步
                .enqueue();
    }

    /**
     * 重复执行后台任务  非单个任务，多个任务
     * 测试后台任务 4
     * @param view
     */
    public void testBackgroundWork4(View view) {
        // OneTimeWorkRequest 单个

        // 重复的任务  多次/循环/轮询  , 哪怕设置为 10秒 轮询一次,   那么最少轮询/循环一次 15分钟（Google规定的）
        // 不能小于15分钟，否则默认修改成 15分钟
        PeriodicWorkRequest periodicWorkRequest
                = new PeriodicWorkRequest.Builder(MainWorker3.class, 10, TimeUnit.SECONDS).build();

        // 【状态机】  为什么一直都是 ENQUEUE，因为 你是轮询的任务，所以你看不到 SUCCESS     [如果你是单个任务，就会看到SUCCESS]
        // 监听状态
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        Log.d(MainWorker2.TAG, "状态：" + workInfo.getState().name()); // ENQUEEN   SUCCESS
                        if (workInfo.getState().isFinished()) {
                            Log.d(MainWorker2.TAG, "状态：isFinished=true 同学们注意：后台任务已经完成了...");
                        }
                    }
                });

        WorkManager.getInstance(this).enqueue(periodicWorkRequest);

        // 取消 任务的执行
        // WorkManager.getInstance(this).cancelWorkById(periodicWorkRequest.getId());
    }

    /**
     * 约束条件，约束后台任务执行
     * 测试后台任务 5
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void testBackgroundWork5(View view) {
        // 约束条件，必须满足我的条件，才能执行后台任务 （在连接网络，插入电源 并且 处于空闲时）
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED) // 网络链接中...
                /*.setRequiresCharging(true) // 充电中..
                .setRequiresDeviceIdle(true) // 空闲时.. (例如：你没有玩游戏，你没有看片)*/
                .build();

        /**
         * 除了上面设置的约束外，WorkManger还提供了以下的约束作为Work执行的条件：
         *  setRequiredNetworkType：网络连接设置
         *  setRequiresBatteryNotLow：是否为低电量时运行 默认false
         *  setRequiresCharging：是否要插入设备（接入电源），默认false
         *  setRequiresDeviceIdle：设备是否为空闲，默认false
         *  setRequiresStorageNotLow：设备可用存储是否不低于临界阈值
         */

        // 请求对象
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MainWorker3.class)
                .setConstraints(constraints) // Request关联 约束条件
                .build();

        // 加入队列
        WorkManager.getInstance(this).enqueue(request);
    }

    /**
     * （你怎么知道，他被杀掉后，还在后台执行？）写入文件的方式（SP），向同学们证明 Derry说的 所言非虚
     * 测试后台任务 6
     * @param view
     */
    public void testBackgroundWork6(View view) {
        // 约束条件
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED) // 约束条件，必须是网络连接
                .build();

        // 构建Request
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MainWorker7.class)
                .setConstraints(constraints)
                .build();

        // 加入队列
        WorkManager.getInstance(this).enqueue(request);
    }

    // 从SP里面获取值，显示到界面给用户看就行了
    private final void updateToUI() {
        SharedPreferences sp = getSharedPreferences(MainWorker7.SP_NAME, Context.MODE_PRIVATE);
        int resultValue = sp.getInt(MainWorker7.SP_KEY, 0);
        bt6.setText("测试后台任务六 -- " + resultValue);
    }

    // 监听 SP 里面数据的变化，你只要敢变，我这里就知道啦
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updateToUI();
    }

    // SP归零
    public void spReset(View view) {
        SharedPreferences sp = getSharedPreferences(MainWorker7.SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(MainWorker7.SP_KEY, 0).apply();
        updateToUI();
    }

    /**
     * TODO 分析源码
     * 测试后台任务 6
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void codeStudy(View view) {

        // 请求对象
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MainWorker3.class)
                .build();

        // TODO 1 初始化环境  初始化工作源码
        /**
         * 这是第二次执行getInstance  ---  最终返回：WorkManagerImpl
         *
         * APK清单文件里面（第一次）执行  面试官
         * 1.初始化 数据库 ROOM 来保存你的任务 （持久性保存的） 手机重新，APP被杀掉 没关系 一定执行
         * 2.初始化 埋下伏笔  new GreedyScheduler
         * 3.初始化 配置信息 configuration  （执行的信息，线程池任务，...）
         */
        WorkManager.getInstance(this) // 这是第二次执行，        APK清单文件里面（第一次）执行  面试官
                // TODO 2 加入队列执行 执行流程
                .enqueue(request);

    }
}