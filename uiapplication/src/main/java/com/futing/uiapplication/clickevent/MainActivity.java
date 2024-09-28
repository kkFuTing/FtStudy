package com.futing.uiapplication.clickevent;


import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.futing.uiapplication.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_click;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_click);

        btn_click = findViewById(R.id.btn_click);

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick");
            }
        });
        //return true以后   Log.e(TAG, "onClick");不会打印   true以后
        btn_click.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, "onTouch: " + event.getAction());
//                return true; // 不会打印   Log.e(TAG, "onClick");
                return false; // 会打印   Log.e(TAG, "onClick");
            }
        });
    }
}
