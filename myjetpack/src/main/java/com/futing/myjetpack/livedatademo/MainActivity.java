package com.futing.myjetpack.livedatademo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.futing.myjetpack.R;
import com.futing.myjetpack.lifecycledemo.databus.LiveDataBus;
import com.futing.myjetpack.lifecycledemo.databus.LiveDataBusX;
import com.futing.myjetpack.sunflower.GardenActivity;
import com.futing.myjetpack.workmanagersimple.MainWorker1;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_livadata);
    }

    public void click(View view) {
        if (view.getId() == R.id.btn) {
            Intent intent = new Intent(this, NameActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn2) {
            Intent intent = new Intent(this, TestLiveDataBusActivity.class);
            startActivity(intent);


            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        //真实开发livedata使用步骤二：发送端发送变化；postValue是关键 (postValue子线程使用) setValue主线程使用；不过postValue最终都是执行setValue
                        //发送消息
//                        LiveDataBus.getInstance().with("data", String.class).postValue("jett");
                        LiveDataBusX.getInstance().with("data", String.class).postValue("jett"); //处理粘性事件
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

//            startActivity(intent); //注释上面的，先发再进入接受，也可以收到这就是粘性事件

        } else if (view.getId() == R.id.btn3) {
            Intent intent = new Intent(this, com.futing.myjetpack.databing.MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn4) {
            Intent intent = new Intent(this, com.futing.myjetpack.roomdemo01.MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn5) {
            Intent intent = new Intent(this, com.futing.myjetpack.roomdemo02.MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn6) {
            Intent intent = new Intent(this, com.futing.myjetpack.lsn4_navigationdemo.MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn7) {
            Intent intent = new Intent(this, com.futing.myjetpack.pagingproject.MainActivity.class);

            startActivity(intent);
        } else if (view.getId() == R.id.btn8) {
            Intent intent = new Intent(this, com.futing.myjetpack.use_paging.MainActivity.class);
            startActivity(intent);

        } else if (view.getId() == R.id.btn9) {
            Intent intent = new Intent(this, com.futing.myjetpack.use_paging2.MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn10) {
            Intent intent = new Intent(this, com.futing.myjetpack.use_paging_db.MainActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.btn11) {
            Intent intent = new Intent(this, com.futing.myjetpack.workmanagersimple.MainActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.btn12) {
            Intent intent = new Intent(this, GardenActivity.class);
            startActivity(intent);
        }
    }


}
