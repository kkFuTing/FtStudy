package com.futing.ftstudy.webview;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.futing.ftstudy.BuildConfig;
import com.futing.ftstudy.R;

import java.io.File;

public class WebViewActivity extends AppCompatActivity {
    private WebView      webView;
    private LinearLayout fileInfoLayout;
    private TextView     fileNameView;
    private TextView fileSizeView;
    private Button   downloadButton;

    private String downloadUrl;
    private String downloadFileName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webview);
        fileInfoLayout = findViewById(R.id.file_info_layout);
        fileNameView = findViewById(R.id.file_name);
        fileSizeView = findViewById(R.id.file_size);
        downloadButton = findViewById(R.id.download_button);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                if (url.endsWith(".rar") || url.endsWith(".zip")) {
                    downloadUrl = url;
                    downloadFileName = URLUtil.guessFileName(url, null, null);
                    showFileInfo(downloadFileName, "26MB");
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.endsWith(".rar") || url.endsWith(".zip")) {
                    downloadUrl = url;
                    downloadFileName = URLUtil.guessFileName(url, null, null);
                    showFileInfo(downloadFileName, "26MB");
                    return true;
                }
                return false;
            }
        });

        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                downloadFile(url);
            }
        });

//        webView.loadUrl("https://www.example.com");
        // 加载本地的 index.html
        webView.loadUrl("file:///android_asset/index.html");


    }

    private void showFileInfo(String fileName, String fileSize) {
        webView.setVisibility(View.GONE);
        fileInfoLayout.setVisibility(View.VISIBLE);
        fileNameView.setText(fileName);
        fileSizeView.setText(fileSize);
        downloadButton.setText("下载文件");
        downloadButton.setEnabled(true);
    }

    private void downloadFile(String url) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

        String fileName = URLUtil.guessFileName(url, null, null);
        request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(url));
        request.addRequestHeader("User-Agent", System.getProperty("http.agent"));
        request.setTitle(fileName);
        request.setDescription("Downloading file...");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        if (downloadManager != null) {
            downloadManager.enqueue(request);
            downloadButton.setText("下载中...");
            downloadButton.setEnabled(false);

            // 监听下载完成
            registerReceiver(new DownloadCompleteReceiver(fileName), new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        } else {
            Toast.makeText(WebViewActivity.this, "Download manager is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private class DownloadCompleteReceiver extends BroadcastReceiver {
        private String fileName;

        public DownloadCompleteReceiver(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            downloadButton.setText("用其他应用打开");
            downloadButton.setEnabled(true);
            downloadButton.setOnClickListener(v -> {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
                Uri fileUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);
                Intent openFileIntent = new Intent(Intent.ACTION_VIEW);
                openFileIntent.setDataAndType(fileUri, getMimeType(file.getAbsolutePath()));
                openFileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(openFileIntent);
            });
        }

        private String getMimeType(String path) {
            String extension = MimeTypeMap.getFileExtensionFromUrl(path);
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
    }
}