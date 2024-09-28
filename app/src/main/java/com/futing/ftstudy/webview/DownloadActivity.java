package com.futing.ftstudy.webview;

import static com.futing.ftstudy.utils.MimeTypeUtil.getMimeType;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import java.io.File;

import com.futing.ftstudy.BuildConfig;
import com.futing.ftstudy.R;

public class DownloadActivity extends AppCompatActivity {
    private String downloadUrl;
    private String fileName;

    private Button downloadButton;
    private ProgressBar progressBar;
    private String mimeType;
    private ImageView fileIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        fileIcon = findViewById(R.id.file_icon);
        TextView fileNameView = findViewById(R.id.file_name);
        TextView fileSizeView = findViewById(R.id.file_size);
        downloadButton = findViewById(R.id.download_button);
        progressBar = findViewById(R.id.progress_bar);

        Intent intent = getIntent();
        downloadUrl = intent.getStringExtra("download_url");
        fileName = intent.getStringExtra("file_name");
        String fileSize = intent.getStringExtra("file_size");
        mimeType = intent.getStringExtra("mime_type");
        fileNameView.setText(fileName);
        fileSizeView.setText("文件大小: " + fileSize);

        setFileIcon(fileName,mimeType);

        downloadButton.setOnClickListener(v -> downloadFile(downloadUrl));
    }

    private void setFileIcon(String fileName, String mimeType) {
        String fileExtension = getFileExtension(fileName);
        int iconResource;
        switch (fileExtension) {
            case "rar":
                iconResource = R.drawable.ic_launcher_background;
                break;
            case "zip":
                iconResource = R.drawable.ic_launcher_background;
                break;
            // Add more cases for different file types as needed
            default:
                if (mimeType != null) {
                    if (mimeType.equals("application/x-rar-compressed")) {
                        iconResource = com.qmuiteam.qmui.R.drawable.qmui_s_switch_track;
                    } else if (mimeType.equals("application/zip")) {
                        iconResource = R.drawable.ic_launcher_background;
                    } else {
                        iconResource = R.drawable.ic_launcher_background;
                    }
                } else {
                    iconResource = R.drawable.ic_launcher_background;
                }
                break;

        }
        fileIcon.setImageResource(iconResource);
    }

    private String getFileExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1).toLowerCase();
        }
        return extension;
    }
    private void downloadFile(String url) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle(fileName);
        request.setDescription("Downloading file...");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        if (downloadManager != null) {
            long downloadId = downloadManager.enqueue(request);
            showDownloadingState();

            registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                    if (downloadId == id) {
                        showDownloadCompleteState();
                    }
                }
            }, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        } else {
            Toast.makeText(DownloadActivity.this, "Download manager is not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDownloadingState() {
        downloadButton.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void showDownloadCompleteState() {
        progressBar.setVisibility(View.GONE);
        downloadButton.setText("用其他应用打开");
        downloadButton.setVisibility(View.VISIBLE);
        downloadButton.setOnClickListener(v -> openDownloadedFile());
    }

    private void openDownloadedFile() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
        Uri fileUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", file);
        Intent openFileIntent = new Intent(Intent.ACTION_VIEW);
        getMimeType("abc.jpg");
        openFileIntent.setDataAndType(fileUri, getMimeType(file.getAbsolutePath()));
        openFileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (openFileIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(openFileIntent);
        } else {
            Toast.makeText(this, "No application found to open this file", Toast.LENGTH_SHORT).show();
        }
    }


}
