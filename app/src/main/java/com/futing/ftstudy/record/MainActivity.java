package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String fileNames[] = null;
    private Player mPlayer = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testBitMap();
        try {
            fileNames = getAssets().list("sound");
        } catch (IOException e) {
            e.printStackTrace();
        }

        findViewById(R.id.single_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSingleFile();
            }
        });
        findViewById(R.id.multi_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 0;
                playMultiFiles();
            }
        });

        findViewById(R.id.multi_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelPlay();
            }
        });
    }

    /**
     * bitmap 学习
     */
    public static final String TAG = "MainActivityTAG";

    private void testBitMap() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        Log.d(TAG, bitmap.getAllocationByteCount() + "\n"
                + "" + bitmap.getByteCount() + "\n"
                + "" + bitmap.getRowBytes() + "\n"
                + "getHeight:" + bitmap.getHeight() + "\n"
                + "" + bitmap.getRowBytes() * bitmap.getHeight() + "\n"
                + "getWidth:" + bitmap.getWidth() + "\n"
                + "" + bitmap.getWidth() * bitmap.getHeight() + "\n"
                + "" + (bitmap.getWidth() * bitmap.getHeight() + "\n"
                + "" + bitmap.getByteCount() / (bitmap.getWidth() * bitmap.getHeight())) + "\n"
                + "设备的densityDpi" + bitmap.getDensity() + "\n"//手机的的
                + "设备的densityDpi" + getResources().getDisplayMetrics().densityDpi + "\n"//手机的的
        );
    }

    // 播放单个音频文件
    private void playSingleFile() {
        mPlayer.removeIMultiCallBackPlay();
        //自动播放
        mPlayer.play(this, "sound/" + fileNames[0]);
        mPlayer.setICallBackPlay(new ICallBackPlay() {
            @Override
            public void start() {
            }

            @Override
            public void error(Exception e) {
            }

            @Override
            public void finish() {

            }
        });

    }

    int index = 0;
    int mTotal = 0;

    // 播放多个音频文件
    private void playMultiFiles() {
        final String[] arr = fileNames;
        mTotal = arr.length;
        mPlayer.play(this, "sound/" + arr[index], 0, mTotal);
        mPlayer.setIMultiCallBackPlay(new IMultiCallBackPlay() {
            @Override
            public void start() {

            }

            @Override
            public void progress(String path, int current, int total) {
                index++;
                if (index < mTotal) {
                    mPlayer.play(MainActivity.this, "sound/" + arr[index], index, mTotal);
                }

            }

            @Override
            public void error(String path, Exception e) {
            }

            @Override
            public void finish() {
            }
        });

    }

    //取消播放
    private void cancelPlay() {
        mPlayer.stop();
        mPlayer.removeIMultiCallBackPlay();
    }
}