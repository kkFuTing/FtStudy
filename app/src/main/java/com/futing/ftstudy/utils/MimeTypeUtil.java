package com.futing.ftstudy.utils;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import java.util.HashMap;
import java.util.Map;

public class MimeTypeUtil {
    private static final Map<String, String> MIME_TYPES;

    static {
        MIME_TYPES = new HashMap<>();
        MIME_TYPES.put("3gp", "video/3gpp");
        MIME_TYPES.put("apk", "application/vnd.android.package-archive");
        MIME_TYPES.put("asf", "video/x-ms-asf");
        MIME_TYPES.put("avi", "video/x-msvideo");
        MIME_TYPES.put("bin", "application/octet-stream");
        MIME_TYPES.put("bmp", "image/bmp");
        MIME_TYPES.put("c", "text/plain");
        MIME_TYPES.put("class", "application/octet-stream");
        MIME_TYPES.put("conf", "text/plain");
        MIME_TYPES.put("cpp", "text/plain");
        MIME_TYPES.put("doc", "application/msword");
        MIME_TYPES.put("docx", "application/msword");
        MIME_TYPES.put("xls", "application/vnd.ms-excel");
        MIME_TYPES.put("xlsx", "application/vnd.ms-excel");
        MIME_TYPES.put("exe", "application/octet-stream");
        MIME_TYPES.put("gif", "image/gif");
        MIME_TYPES.put("gtar", "application/x-gtar");
        MIME_TYPES.put("gz", "application/x-gzip");
        MIME_TYPES.put("h", "text/plain");
        MIME_TYPES.put("htm", "text/html");
        MIME_TYPES.put("html", "text/html");
        MIME_TYPES.put("jar", "application/java-archive");
        MIME_TYPES.put("java", "text/plain");
        MIME_TYPES.put("jpeg", "image/jpeg");
        MIME_TYPES.put("jpg", "image/jpeg");
        MIME_TYPES.put("js", "application/x-javascript");
        MIME_TYPES.put("log", "text/plain");
        MIME_TYPES.put("m3u", "audio/x-mpegurl");
        MIME_TYPES.put("m4a", "audio/mp4a-latm");
        MIME_TYPES.put("m4b", "audio/mp4a-latm");
        MIME_TYPES.put("m4p", "audio/mp4a-latm");
        MIME_TYPES.put("m4u", "video/vnd.mpegurl");
        MIME_TYPES.put("m4v", "video/x-m4v");
        MIME_TYPES.put("mov", "video/quicktime");
        MIME_TYPES.put("mp2", "audio/x-mpeg");
        MIME_TYPES.put("mp3", "audio/x-mpeg");
        MIME_TYPES.put("mp4", "video/mp4");
        MIME_TYPES.put("mpc", "application/vnd.mpohun.certificate");
        MIME_TYPES.put("mpe", "video/mpeg");
        MIME_TYPES.put("mpeg", "video/mpeg");
        MIME_TYPES.put("mpg", "video/mpeg");
        MIME_TYPES.put("mpg4", "video/mp4");
        MIME_TYPES.put("mpga", "audio/mpeg");
        MIME_TYPES.put("msg", "application/vnd.ms-outlook");
        MIME_TYPES.put("ogg", "audio/ogg");
        MIME_TYPES.put("pdf", "application/pdf");
        MIME_TYPES.put("png", "image/png");
        MIME_TYPES.put("pps", "application/vnd.ms-powerpoint");
        MIME_TYPES.put("ppt", "application/vnd.ms-powerpoint");
        MIME_TYPES.put("pptx", "application/vnd.ms-powerpoint");
        MIME_TYPES.put("prop", "text/plain");
        MIME_TYPES.put("rc", "text/plain");
        MIME_TYPES.put("rmvb", "audio/x-pn-realaudio");
        MIME_TYPES.put("rtf", "application/rtf");
        MIME_TYPES.put("sh", "text/plain");
        MIME_TYPES.put("tar", "application/x-tar");
        MIME_TYPES.put("tgz", "application/x-compressed");
        MIME_TYPES.put("txt", "text/plain");
        MIME_TYPES.put("wav", "audio/x-wav");
        MIME_TYPES.put("wma", "audio/x-ms-wma");
        MIME_TYPES.put("wmv", "audio/x-ms-wmv");
        MIME_TYPES.put("wps", "application/vnd.ms-works");
        MIME_TYPES.put("xml", "text/xml");
        MIME_TYPES.put("z", "application/x-compress");
        MIME_TYPES.put("zip", "application/x-zip-compressed");
        MIME_TYPES.put("", "*/*");
    }

    public static String getMimeType(String path) {
        String extension = MimeTypeMap.getFileExtensionFromUrl(path);
        if (TextUtils.isEmpty(extension)) {
            extension = getExtension(path);
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
    }

//    public static String getMimeType(String path) {
//        String extension = getExtension(path);
//        if (TextUtils.isEmpty(extension)) {
//            return "application/octet-stream";
//
//        }
//        extension = extension.toLowerCase();
//        if (MIME_TYPES.containsKey(extension)) {
//            return MIME_TYPES.get(extension);
//        }
//        return "application/octet-stream";
//    }

    private static String getExtension(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            int lastIndex = fileName.lastIndexOf('.');
            if (lastIndex != -1 && lastIndex < fileName.length() - 1) {
                return fileName.substring(lastIndex + 1);
            }
        }
        return "";
    }
}
