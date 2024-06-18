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
import android.webkit.WebSettings;
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
import com.futing.ftstudy.utils.FileUtil;

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
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //单纯设置不生效
        modifyWebSettings(webView);
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                //进行下载处理，跳转浏览器
                //todo
//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//
                //调用系统下载方法
//                String fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);


                // 提取文件名
                String fileName = FileUtil.extractFileNameFromContentDisposition(contentDisposition);
                if (fileName == null) {
                    fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                }

                Intent intent = new Intent(WebViewActivity.this, DownloadActivity.class);
                intent.putExtra("download_url", url);
                intent.putExtra("file_name", fileName);
                intent.putExtra("file_size", formatFileSize(contentLength));
                intent.putExtra("mimeType", mimetype);
                startActivity(intent);
            }
        });

        webView.loadUrl("file:///android_asset/index.html");
    }
    private  void modifyWebSettings(WebView appView) {
        WebSettings settings = appView.getSettings();
        //允许放大
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        // 禁用默认的放大行为
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
    }
    private String formatFileSize(long size) {
        if (size >= 1024 * 1024) {
            return String.format("%.1f MB", size / (1024.0 * 1024.0));
        } else if (size >= 1024) {
            return String.format("%.1f KB", size / 1024.0);
        } else {
            return size + " B";
        }
    }
}