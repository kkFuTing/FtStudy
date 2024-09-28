package com.futing.opensourelib.eventbus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.futing.opensourelib.R;


// TODO: 2024/9/4 第一家公司的时候自己系的吧  ，eventbus的实现原理；
public class Main5Activity extends AppCompatActivity {


    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        EventBus.getDefualt().register(this);
        text = findViewById(R.id.tv);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void aaa(String s) {
        text.setText(s +"+:"+Thread.currentThread().getName());
        Toast.makeText(this, "啦啦啦", Toast.LENGTH_SHORT).show();
    }

    public void btEventbus(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefualt().post("天空很漂亮");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                EventBus.getDefualt().post(new EventBusTest.User("都岁江"));

            }
        }).start();
    }
}
