package com.ft.netmasterlib;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.File;

public class NetMasterActivity extends AppCompatActivity {
    public static final String TAG = "NetMasterActivity";
    private             String url;
    private String dir;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netmaster);


        url = "https://mic-mj.oss-cn-hangzhou.aliyuncs.com/super_app/test/%E9%BB%91%E7%99%BD%E7%AE%80%E7%BA%A6PPT.pptx";
        dir = getExternalCacheDir() +"";
        name = "a.ppt";

    }

    /**
     * okHTTP 兼容性较好，存在同个文件okGO文件没有进度回调，okHTTP有
     * @param view
     */

    public void okHTTP(View view) {

        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.downloadFile(url
                , dir+name, progress -> {
                    Log.e(TAG, progress + "");
                });
    }

    public void okGO(View view) {

        OkGo.<File>get(url).tag(this).execute(new FileCallback(dir, name) {
            @Override
            public void onSuccess(Response<File> response) {
            }

            @Override
            public void downloadProgress(Progress progress) {
                super.downloadProgress(progress);
                // 更新进度条
                Log.d(TAG, "downloadProgress fraction：" + progress.fraction);
                Log.d(TAG, "downloadProgress currentSize：" + progress.currentSize);
            }

        });
    }
}