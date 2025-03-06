package com.example.kotlinlib.ubt;

import android.os.FileObserver;

import timber.log.Timber;
//       lifecycleScope.launch (Dispatchers.IO){
//    AssetUtils.copyAssetsToSdCard(MyApplication.myApplication)
//}
//
//// 初始化 FileChangeObserver
//FileChangeObserver().startWatching()
public class FileChangeObserver extends FileObserver {
    private static final String DIRECTORY_PATH = "/data/data/com.ubt.uworld.chat/ASR.md";

    public FileChangeObserver() {
        super(DIRECTORY_PATH, FileObserver.MOVED_TO | FileObserver.MODIFY | FileObserver.CREATE | FileObserver.DELETE);
    }

    @Override
    public void onEvent(int event, String path) {
        if (path != null) {
            switch (event) {
                case FileObserver.CREATE:
                    Timber.i("File created:path=%s", path);
                    break;
                case FileObserver.MODIFY:
                    Timber.i("File modified:%s", path);
                    break;
                case FileObserver.DELETE:
                    Timber.i("File deleted:=%s", path);
                    break;
                case FileObserver.MOVED_TO:
                    Timber.i("File MOVED_TO:=%s", path);
                    break;
            }
        }
    }
}
