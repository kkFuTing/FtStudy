package com.futing.ftstudy;


import static com.futing.ftstudy.utils.ResFinder.findViewById;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import com.example.firebasepush.FCMUtils;
import com.ft.netmasterlib.NetMasterActivity;
import com.futing.ftstudy.language.LanguageActivity;
import com.futing.ftstudy.share.SystemShareActivity;
import com.futing.ftstudy.utils.NetworkUtils;
import com.futing.ftstudy.webview.WebViewActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
        TextView textView = findViewById(R.id.tv_fcm);
//        textView.setText(GoogleApiAvailability.makeGooglePlayServicesAvailable());
//       realme  获取令牌成功fUP0izzUStGf7U83nBLTx-:APA91bH0CqbSQqsF7w6JcoNiU-p_yM_tcol4jzzRFjPiDcELwxHW0ToFejqgkGeLUYIT1zhXpidMjYcq4t9eHj0xCd8UTOWSrTYvNpOzUYvaGgyUnuTDTmRdvRjQHwRyqrVh46gyrf72
        textView.setText(NetworkUtils.getIPAddress(this));
        FCMUtils.getToken(this);

    }

    public void bt_string_id_setting(View view) {
        startActivity(new Intent(this, LanguageActivity.class));
        String host = "10.8.9.6";
        int errorCode = 8899;
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