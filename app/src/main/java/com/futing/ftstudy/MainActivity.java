package com.futing.ftstudy;


import static com.futing.ftstudy.utils.ResFinder.findViewById;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.firebasepush.FCMUtils;
import com.ft.netmasterlib.NetMasterActivity;
import com.futing.ftstudy.language.LanguageActivity;
import com.futing.ftstudy.share.SystemShareActivity;
import com.futing.ftstudy.utils.NetworkUtils;
import com.futing.ftstudy.webview.WebViewActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private final static String TAG_HANDLER = "TAG_HANDLER";

    private TextView viewById;
    private TextView txBeijingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewById = findViewById(R.id.tv_show);
        txBeijingTime = findViewById(R.id.tv_beijing_time);
        testHandler();

//        framework
        studyHandler();
        switchThreadToMain();
        CraetrThread();
        CraeteMessage();

        testglide();
    }

    private void CraeteMessage() {
        new  Thread(new Runnable() {
            @Override
            public void run() {
                myhandler.sendMessage(Message.obtain());
            }
        }).start();

    }

    private void CraetrThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Looper.loop();
                Handler handler = new Handler() {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        Log.e(TAG_HANDLER, "sendEmptyMessage:::" + "THREAD:" + Thread.currentThread().getName());
                    }


                };
                Looper.myLooper().quit();
                handler.sendEmptyMessage(100);

            }
        }).start();
    }

    private void switchThreadToMain() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               Log.e(TAG_HANDLER, "sendEmptyMessage:::" + "THREAD:" + Thread.currentThread().getName());
               myhandler.sendEmptyMessage(10);
           }
       }).start();
    }

    MyHandler1 myhandler = new MyHandler1();
    static class  MyHandler1 extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.e(TAG_HANDLER, msg + "THREAD:" + Thread.currentThread().getName());
        }
    }

    private void studyHandler() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("MainActivity=", "thread.run:"+Thread.currentThread().getName());
                //切线程
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("MainActivity=", "handler.post.run:"+Thread.currentThread().getName());
                    }
                });
            }
        });
        thread.start();
    }

    private void testglide() {
        //调用层调用
//阅读源码时所使用的技巧，简单概括就是八个字：抽丝剥茧、点到即止。
        //应该认准一个功能点，然后去分析这个功能点是如何实现的。
        // 但只要去追寻主体的实现逻辑即可，千万不要试图去搞懂每一行代码都是什么意思，那样很容易会陷入到思维黑洞当中，
        // 而且越陷越深。因为这些庞大的系统都不是由一个人写出来的，每一行代码都想搞明白，就会感觉自己是在盲人摸象，永远也研究不透。
        // 如果只是去分析主体的实现逻辑，那么就有比较明确的目的性，这样阅读源码会更加轻松，也更加有成效。
//        因为Glide从来都不会直接将图片的完整尺寸全部加载到内存中，而是用多少加载多少。Glide会自动判断ImageView的大小，然后只将这么大的图片像素加载到内存当中，帮助我们节省内存开支。
        //在绝大多数情况下我们都是不需要指定图片大小的，因为Glide会自动根据ImageView的大小来决定图片的大小。

        ImageView image = findViewById(R.id.iv_image);
        Glide.with(this)

                .load("https://gips0.baidu.com/it/u=838505001,1009740821&fm=3028&app=3028&f=PNG&fmt=auto&q=100&size=f254_80")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .into(image);
    }

    /**
     * 2024/08/13 优奇怪的面试题
     * 1，2，3 执行顺序
     */
    private void testHandler() {


        Log.e("MainActivity=T::", "1"+"::"+Thread.currentThread().getName());
        MyHandler myHandler = new MyHandler();
//        Message message = new Message();
//        message.obj = (Runnable) () -> {
//            Log.e("MainActivity=","2");
//
//        };



        new Thread(new Runnable() {
            @Override
            public void run() {
                myHandler.post((Runnable) () -> {
                    Log.e("MainActivity=T::", "2"+"::"+Thread.currentThread().getName());
                    myHandler.sendMessage(Message.obtain());
                });
            }
        }).start();

//        myHandler.sendMessage(System.out.println(2) );
//        Message message = new Message();
//        message.obj = System.out.println(2);
//        message.what = System.out.println(2);
//        myHandler.sendMessage();
    }

    public void btOpenmemorylib(View view) {
        startActivity(new Intent(this, com.futing.memorylib.MainActivity.class));
    }



    public void btOpensourelibOnclick(View view) {
        startActivity(new Intent(this, com.futing.opensourelib.MainActivity.class));
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.e("MainActivity=T::", "3" +"::"+Thread.currentThread().getName());
        }
    }


    public void current_time(View view) {
        long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = sdf.format(date);
        Log.e("MainActivity", "年月日时分秒格式：" + timestamp);
        Log.e("MainActivity", "年月日时分秒格式：" + formattedDateTime);
        viewById.setText(formattedDateTime + ":::" + timestamp);


    }

    public void current_bj_time(View view) {
        // 获取当前时间
        Date currentTime = new Date();

        // 设置时区为北京时间
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");

        // 格式化日期时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        String beijingTime = sdf.format(currentTime);
        txBeijingTime.setText(beijingTime + "::");
    }

    public void bt_share(View view) {
        Intent intent = new Intent(this, SystemShareActivity.class);
        startActivity(intent);
    }

    public void bt_get_fcm_token(View view) {
        TextView textView = findViewById(R.id.tv_fcm);
//        textView.setText(GoogleApiAvailability.makeGooglePlayServicesAvailable());
//       realme  获取令牌成功fUP0izzUStGf7U83nBLTx-:APA91bH0CqbSQqsF7w6JcoNiU-p_yM_tcol4jzzRFjPiDcELwxHW0ToFejqgkGeLUYIT1zhXpidMjYcq4t9eHj0xCd8UTOWSrTYvNpOzUYvaGgyUnuTDTmRdvRjQHwRyqrVh46gyrf72
        textView.setText(NetworkUtils.getIPAddress(this));
        FCMUtils.getToken(this);

    }

    public void bt_string_id_setting(View view) {
        startActivity(new Intent(this, LanguageActivity.class));
        String host = "10.2.9.6";
        int errorCode = 6688;
        String description = "一个很严重的错误";
        TextView textView = findViewById(R.id.tv_string);
//        String text = String.format(Locale.getDefault(), "无法打开网页，因为%s暂时无法连接。(%d)\n\n详情:%s", host, errorCode, description);
        String text = String.format(Locale.getDefault(), getString(R.string.reason), host, errorCode, description);
        textView.setText(text);
    }

    public void btOpenWebView(View view) {
        startActivity(new Intent(this, WebViewActivity.class));
    }

    public void btOpenNetMaster(View view) {
        startActivity(new Intent(this, NetMasterActivity.class));

    }

}