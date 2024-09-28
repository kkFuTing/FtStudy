package com.futing.memorylib;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by futing on 2024/8/14.
 */
public class Utils {


    public static boolean createDumpFile(Context context) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ssss");
        String createTime = dateFormat.format(new Date(System.currentTimeMillis()));
        File cacheDir = context.getCacheDir();
        String path = cacheDir.getAbsolutePath() + "/" + createTime + ".hprof";

        try {
            Debug.dumpHprofData(path);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void show(Context context,boolean result) {
        if (result) {
            Toast.makeText(context, "成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "失败", Toast.LENGTH_SHORT).show();
        }


    }
}
