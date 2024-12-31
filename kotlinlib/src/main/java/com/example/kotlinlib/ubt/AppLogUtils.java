package com.example.kotlinlib.ubt;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppLogUtils {

    private static final int LOG_ROWS = 2000;
    private final ExecutorService executorService;

    // Private constructor to prevent instantiation
    private AppLogUtils() {
        executorService = Executors.newSingleThreadExecutor();
    }

    private static final class InstanceHolder {
        static final AppLogUtils instance = new AppLogUtils();
    }

    public static AppLogUtils getInstance() {
        return InstanceHolder.instance;
    }

    // Function to push log file
    public void ossPushFile(final Context context) {
        executorService.submit(() -> {
            Log.d("AppAppLogUtils", "ossPushFile: Thread=" + Thread.currentThread().getName());
            List<String> recentLogs = getRecentLogs();
        });
    }

    // Get current date time with milliseconds
    private String getCurrentDateTimeWithMillis() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return currentDateTime.format(formatter);
    }

    // 获取最近的 LOG_ROWS 条日志
    private List<String> getRecentLogs() {
        List<String> logs = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec("logcat -d -t " + LOG_ROWS);  // -d: dump logs, -t: limit count
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                logs.add(line);
            }
            reader.close();
        } catch (IOException e) {
            Log.e("AppLogUtils", "Error getting logs", e);
        }
        return logs;
    }

    // Write logs to storage and return file path
    private String writeLogsToStorage(Context context, List<String> logs, String fileName) {
        try {
            File directory = new File(context.getExternalCacheDir(), "Logs");
            if (!directory.exists()) {
                directory.mkdirs();  // Create directory if not exists
            }

            File logFile = new File(directory, fileName);

            // Write logs to file
            FileWriter fileWriter = new FileWriter(logFile, true);  // 'true' for append mode
            for (String log : logs) {
                fileWriter.write(log + "\n");
            }
            fileWriter.close();
            Log.d("AppLogUtils", "Logs written to " + logFile);
            return logFile.getAbsolutePath();
        } catch (IOException e) {
            Log.e("AppLogUtils", "Error writing logs to storage", e);
        }
        return "";
    }
}
