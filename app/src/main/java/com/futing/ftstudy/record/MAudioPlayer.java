package com.futing.ftstudy.record;


import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MAudioPlayer extends Activity {

    private static final String PARAM_PATH = "path";
    private static final String PARAM_PATHS = "paths";

    private static final int START = 1;// 开始播放回调
    private static final int PROGRESS = 2;// 单个文件播放完成回调。单数组中只有一个文件时，不回调。
    private static final int ERROR = 3;// 播放失败回调
    private static final int FINISH = 4;// 所有播放完成回调
    private static final String PLAY_SINGLE_FILE_ACTION = "playSingleFile";
    private static final String PLAY_MULTI_FILES_ACTION = "playMultiFiles";
    private static final String PLAY_CANCEL_ACTION = "cancelPlay";
    private Player mPlayer = new Player();

    protected boolean onExecute(String action, JSONArray params, CallbackWrapper callback) throws JSONException {
        if (action.equals(PLAY_SINGLE_FILE_ACTION)) {
            this.playSingleFile(params, callback);
            return true;
        } else if (action.equals(PLAY_MULTI_FILES_ACTION)) {
            this.playMultiFiles(params, callback);
            return true;
        } else if (action.equals(PLAY_CANCEL_ACTION)) {
            this.cancelPlay(params, callback);
            return true;
        }
        return false;
    }

    // 播放单个音频文件
    private void playSingleFile(JSONArray params, CallbackWrapper callbackContext) {
        if (params != null && params.length() > 0) {
            JSONObject optionObj = params.optJSONObject(0);
            String strMethod = optionObj.optString(PARAM_PATH);
            //自动播放
            //mPlayer.play(strMethod);
            mPlayer.setICallBackPlay(new ICallBackPlay() {
                @Override
                public void start() {
                    callbackContext.success(START, "start");
                }

                @Override
                public void error(Exception e) {
                    callbackContext.error("Expected one non-empty string argument.");
                }

                @Override
                public void finish() {

                }
            });

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    int index = 0;
    int mTotal = 0;

    // 播放多个音频文件
    private void playMultiFiles(final JSONArray params, final CallbackWrapper callbackContext) {
        if (params != null && params.length() > 0) {
            JSONObject optionObj = params.optJSONObject(0);
            //这个应该是一个数组
            //JSONArray strMethod = optionObj.optJSONArray(PARAM_PATHS);
            final String[] arr = {"aaa", "bbb", "ccc"};
            mTotal = arr.length;
            //mPlayer.play(arr[index], 0, mTotal);
            mPlayer.setIMultiCallBackPlay(new IMultiCallBackPlay() {
                @Override
                public void start() {

                }

                @Override
                public void progress(String path, int current, int total) {
                    index++;
                    //mPlayer.play(arr[index], index, mTotal);
                }

                @Override
                public void error(String path, Exception e) {
                    callbackContext.error("Expected one non-empty string argument.");
                }

                @Override
                public void finish() {
                    callbackContext.success(params);
                }
            });

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    //取消播放
    private void cancelPlay(JSONArray params, CallbackWrapper callbackContext) {
        if (params != null && params.length() > 0) {
            JSONObject optionObj = params.optJSONObject(0);
            JSONArray jsonArray = optionObj.optJSONArray(PARAM_PATH);
            mPlayer.stop();
            callbackContext.success(params);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
