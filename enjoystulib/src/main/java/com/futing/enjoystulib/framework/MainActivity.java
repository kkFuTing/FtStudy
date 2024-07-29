package com.futing.enjoystulib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;

import com.futing.enjoystulib.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                // TODO Auto-generated method stub
                // 你想做的任何事情
                // dosomething()
                // 需要注意，当queueId1e返回true，将会在每次空闲的时候都会调用 gueuerdle
                // 反之要是返回fa1se，则只调用一次。
                return false;
            }
        });
    }
}