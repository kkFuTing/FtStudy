package com.futing.uiapplication.textdraw.activity;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.futing.uiapplication.R;
import com.futing.uiapplication.textdraw.view.SimpleColorChangeTextView;


public class SimpleActivity extends AppCompatActivity {

    SimpleColorChangeTextView mView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        mView1 = findViewById(R.id.color_change_textview);

        //属性动画
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onStartLeft(null);
            }
        },2000);
    }

    public void onStartLeft(View view){
        // TODO: 2024/8/27 SimpleColorChangeTextView 为什么看里面是百分比 mPercent  字段这个percent？？？  说是反会执行这个方法 setPercent(float mPercent)
        //属性动画改变颜色渐百分比
        ObjectAnimator.ofFloat(mView1,"percent",0,1).setDuration(5000).start();
    }

    public void onStartRight(View view){
//        mView1.setDirection(ColorChangeTextView2.DIRECTION_RIGHT);
//        ObjectAnimator.ofFloat(mView1,"progress",0,1).setDuration(2500).start();
    }

    public void onStartTop(View view){
//        mView1.setDirection(ColorChangeTextView2.DIRECTION_TOP);
//        ObjectAnimator.ofFloat(mView1,"progress",0,1).setDuration(2500).start();
    }

    public void onStartBottom(View view){
//        mView1.setDirection(ColorChangeTextView2.DIRECTION_BOTTOM);
//        ObjectAnimator.ofFloat(mView1,"progress",0,1).setDuration(2500).start();
    }
}
