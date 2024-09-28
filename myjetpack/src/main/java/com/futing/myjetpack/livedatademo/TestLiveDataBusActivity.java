package com.futing.myjetpack.livedatademo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.futing.myjetpack.R;
import com.futing.myjetpack.lifecycledemo.databus.LiveDataBus;
import com.futing.myjetpack.lifecycledemo.databus.LiveDataBusX;


public class TestLiveDataBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedatabus);
        //真实开发livedata使用步骤三：接收端接收数据；  .observe 是关键
//        LiveDataBus.getInstance().with("data", String.class)
        LiveDataBusX.getInstance().with("data", String.class) //处理粘性事件
//                @NonNull Observer<? super T> observer 只可以改，不可以读
                    .observe(this, new Observer<String>() {
                        @Override
                        public void onChanged(String s) {
                            Log.i("futing", "222");
                            if(s!=null)
                            Toast.makeText(TestLiveDataBusActivity.this, s, Toast.LENGTH_SHORT).show();
                        }
                    });
    }

    @Override
    protected void onResume() {
//        com.futing.myjetpack                 I  222
//        com.futing.myjetpack                 I  onResume前
//        com.futing.myjetpack                 I  onResume后
//        com.futing.myjetpack                 I  222

        Log.i("futing", "onResume前");
        super.onResume();
        Log.i("futing", "onResume后");
    }
}
