package com.example.myapplication;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;


public class Player implements MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener {
    private static final String TAG = "Player";
    public MediaPlayer mediaPlayer; // 媒体播放器
    public String mPlayUrl;
    private int mIndex;
    private int mTotal;

    // 初始化播放器
    public Player() {
        super();
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);// 设置媒体流类型
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnCompletionListener(this);
        }

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ICallBackPlay mICallBackPlay;
    private IMultiCallBackPlay mIMultiCallBackPlay;

    public void setICallBackPlay(ICallBackPlay iCallBackPlay) {
        this.mICallBackPlay = iCallBackPlay;
    }

    public void setIMultiCallBackPlay(IMultiCallBackPlay iMultiCallBackPlay) {
        this.mIMultiCallBackPlay = iMultiCallBackPlay;
    }

    public void removeCalBackPlay(){
        if (mICallBackPlay != null) {
            mICallBackPlay = null;
        }
    }

    public void  removeIMultiCallBackPlay(){
        if (mIMultiCallBackPlay != null) {
            mIMultiCallBackPlay = null;
        }
    }

    public void play(Context context,String playUrl) {
        play(context,playUrl, 0, 0);
    }

    /**
     * @param url   播放url
     * @param index 当前播放第几个
     * @param total 公共播放个数
     */
    public void play(Context context,String url, int index, int total) {
        if (mediaPlayer == null) return;
        mPlayUrl = url;
        mIndex = index;
        mTotal = total;
        Log.i(TAG, "play: " + url);
        try {
            //打开音乐文件shot.mp3
            mediaPlayer.reset();
            AssetFileDescriptor assetFileDescriptor = context.getAssets().openFd(url);
            //设置媒体播放器的数据资源
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
            assetFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
            if (mICallBackPlay != null) {
                mICallBackPlay.error(e);
            }
            if (mIMultiCallBackPlay != null) {
                mIMultiCallBackPlay.error(mPlayUrl, e);
            }
        }
        //mediaPlayer.seekTo(0);

        if (mICallBackPlay != null) {
            mICallBackPlay.start();
        }
        if (mIMultiCallBackPlay != null && index == 0) {
            mIMultiCallBackPlay.start();
        }

    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            //mediaPlayer.release();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        Log.i(TAG, "onPrepared: ");
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.i(TAG, "onCompletion: ");
        if (mICallBackPlay != null) {
            mICallBackPlay.finish();
        }

        if (mIMultiCallBackPlay != null) {
            mIMultiCallBackPlay.progress(mPlayUrl, mIndex, mTotal);
        }

        if (mIMultiCallBackPlay != null && mIndex == mTotal - 1) {
            mIMultiCallBackPlay.finish();
        }
    }

}
