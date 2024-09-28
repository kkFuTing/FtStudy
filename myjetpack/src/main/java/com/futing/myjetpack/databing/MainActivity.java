package com.futing.myjetpack.databing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.futing.myjetpack.BR;
import com.futing.myjetpack.R;
import com.futing.myjetpack.databinding.ActivityMainDatabingBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainDatabingBinding binding;
    //从model层来的数据
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        使用dataBinding 步骤三 绑定UI  此处只进行一些初始化！！！
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_databing);

        user = new User("jett", "123");
        //  使用dataBinding 步骤四 绑定对象
        binding.setUser(user);//所有
//        binding.setVariable(BR.name, "21341234123");//只监听name？？

        //没个1s刷新ui
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        //  使用dataBinding 步骤五 此时就随便改数据，UI会自动变化；
                        user.setName(user.getName()+"1");// view.setText(text);
                        user.setPwd(user.getPwd()+"：1");// view.setText(text);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}







