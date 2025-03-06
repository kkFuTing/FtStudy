package com.example.kotlinlib.ubt;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AssetUtils {

    public static void copyAssetsToSdCard(Context context) {
        String assetsDir = "assets";  // 需要拷贝的assets文件夹路径
        File destinationDir = new File(context.getCacheDir(), "my_assets");  // 目标目录

        // 创建目标目录
        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        try {
            // 获取assets目录下的所有文件和子目录
            String[] files = context.getAssets().list(assetsDir);

            if (files != null) {
                for (String file : files) {
                    // 获取源文件路径和目标文件路径
                    File sourceFile = new File(context.getAssets().open(file).toString());
                    File destinationFile = new File(destinationDir, file);

                    // 如果是文件夹则递归调用
                    if (sourceFile.isDirectory()) {
                        copyAssetsToSdCard(context, sourceFile.getPath(), destinationFile.getPath());
                    } else {
                        copyFile(context, sourceFile.getPath(), destinationFile.getPath());
                    }
                }
            }
        } catch (IOException e) {
            Log.e("AssetUtils", "Error copying assets", e);
        }
    }

    private static void copyFile(Context context, String sourcePath, String destinationPath) throws IOException {
        try (InputStream in = context.getAssets().open(sourcePath); 
             OutputStream out = new FileOutputStream(destinationPath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    private static void copyAssetsToSdCard(Context context, String sourceDir, String destinationDir) throws IOException {
        // 创建目录
        File destinationDirFile = new File(destinationDir);
        if (!destinationDirFile.exists()) {
            destinationDirFile.mkdirs();
        }

        String[] files = context.getAssets().list(sourceDir);

        if (files != null) {
            for (String file : files) {
                String sourcePath = sourceDir + "/" + file;
                String destinationPath = destinationDir + "/" + file;

                // 判断文件或目录
                File sourceFile = new File(sourcePath);
                if (sourceFile.isDirectory()) {
                    copyAssetsToSdCard(context, sourcePath, destinationPath);
                } else {
                    copyFile(context, sourcePath, destinationPath);
                }
            }
        }
    }
}
