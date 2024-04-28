package com.futing.ftstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.futing.ftstudy.share.SystemShareActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private TextView viewById;
    private TextView txBeijingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewById = findViewById(R.id.tv_show);
        txBeijingTime = findViewById(R.id.tv_beijing_time);
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
//        FCMUtils.getToken(this);

    }
}