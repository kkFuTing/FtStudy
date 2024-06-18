package com.ft.netmasterlib;

import okhttp3.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class FileDownloader {

    private OkHttpClient client;

    public FileDownloader() {
        // 创建 OkHttpClient 实例
        client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS) // 设置连接超时时间
                .readTimeout(30, TimeUnit.SECONDS)    // 设置读取超时时间
                .build();
    }

    public void downloadFile(String url, String destinationPath, ProgressListener listener) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 下载失败处理
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    // 请求不成功，处理错误
                    throw new IOException("Failed to download file: " + response);
                }

                // 获取响应体
                ResponseBody body = response.body();
                if (body == null) {
                    // 响应体为空，下载失败
                    throw new IOException("Response body is empty");
                }

                // 获取文件总大小
                long totalSize = body.contentLength();

                // 创建文件输出流
                File file = new File(destinationPath);
                FileOutputStream fos = new FileOutputStream(file);

                // 创建输入流
                InputStream inputStream = body.byteStream();

                // 缓冲区大小
                byte[] buffer = new byte[4096];

                // 已下载大小
                long downloadedSize = 0;
                int bytesRead;

                // 开始下载
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    // 写入文件
                    fos.write(buffer, 0, bytesRead);
                    downloadedSize += bytesRead;

                    // 进度回调
                    if (listener != null) {
                        float progress = (float) downloadedSize / totalSize;
                        listener.onProgressUpdate(progress);
                    }
                }

                // 关闭流
                fos.flush();
                fos.close();
                inputStream.close();
            }
        });
    }

    // 进度回调接口
    public interface ProgressListener {
        void onProgressUpdate(float progress);
    }
}
