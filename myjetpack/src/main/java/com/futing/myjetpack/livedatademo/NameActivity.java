package com.futing.myjetpack.livedatademo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.futing.myjetpack.R;

//livedata使用步骤二： 在一个Activity使用
public class NameActivity extends AppCompatActivity {

    MutableLiveData liveData;
    private NameViewModel model;

    private TextView nameTextView;
    private Button btn;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        nameTextView = findViewById(R.id.tvText);
        btn = findViewById(R.id.btn);


        //livedata使用步骤二：2 建立一个观察者  (但是真实开发的时候，都是有一条总线  ，看com.futing.myjetpack.lifecycledemo.databus)
        //需要一个观察者来观察数据
        Observer observer = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                nameTextView.setText(s);
            }
        };

        //livedata使用步骤二：1 在一个Activity使用，获取一个VM
        //获取到viewmodel
        // TODO: 2024/8/24  废弃了，先不管了，视频里面老师也废弃了 ，为了方便看源码
        model = ViewModelProviders.of(this).get(NameViewModel.class);
//        new ViewModelProvider(this).get(NameViewModel.class); //等同于上方 这个是不过时的

        //livedata使用步骤二：3、订阅 （完成这三步后，此时只要字符串发生变化，observer的onChanged就会回调 一次）
        //取出livedata完成订阅
        model.getCurrentName().observe(this, observer);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anotherName = "jett" + (i++);
                model.getCurrentName().setValue(anotherName);
                ////解释 源码中 LiveData.dispatchingValue（）     mDispatchingValue = true; mDispatchInvalidated = false;的用法
                liveData.setValue("1");
            }
        });


        //解释 源码中 LiveData.dispatchingValue（）     mDispatchingValue = true; mDispatchInvalidated = false;的用法
        liveData = new MutableLiveData<String>();
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d("jett", "changed1 :" + s);
                if (s.equals("1")) {
                    liveData.setValue("2");
                }
            }
        });
        ////解释 源码中 LiveData.dispatchingValue（）     mDispatchingValue = true; mDispatchInvalidated = false;的用法
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d("jett", "changed2 :" + s);
            }
        });
    }


}
