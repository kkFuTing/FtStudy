
package com.futing.ftstudy.utils;

import android.content.Context;
import android.text.TextUtils;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DecimalFormat;

public class FileUtil {

    private static final String TAG = "FileUtil";

    /**
     * Use getFilesDir()
     *
     * @param context
     * @param fileName
     * @param byteArr
     * @throws IOException
     */
    public static void writeFileInInternalStorage(Context context, String fileName, byte[] byteArr)
            throws IOException {
        writeFile(context, context.getFilesDir(), fileName, byteArr);
    }

    /**
     * Use getFilesDir()
     *
     * @param context
     * @param fileName
     * @param byteArr
     * @throws IOException
     */
    public static void writeFileInCacheStorage(Context context, String fileName, byte[] byteArr)
            throws IOException {
        writeFile(context, context.getCacheDir(), fileName, byteArr);
    }

    private static void writeFile(Context context, File fileDir, String fileName, byte[] byteArr)
            throws IOException {
        File file = new File(fileDir, fileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(byteArr);
        outputStream.close();
    }

    private static void writeFileFullPath(Context context, String fullFileName, byte[] byteArr)
            throws IOException {
        File file = new File(fullFileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(byteArr);
        outputStream.close();
    }

    public static byte[] readFileFromInternalStorage(Context context, String fileName)
            throws IOException {
        return readFile(context, context.getFilesDir(), fileName);
    }

    public static byte[] readFileFromCacheStorage(Context context, String fileName)
            throws IOException {
        return readFile(context, context.getCacheDir(), fileName);
    }

    private static byte[] readFile(Context context, File dirName, String fileName)
            throws IOException {
        File file = new File(dirName, fileName);
        int size = (int) file.length();
        byte byteArr[] = new byte[size];

        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.read(byteArr, 0, byteArr.length);
        bufferedInputStream.close();

        return byteArr;
    }


    public static byte[] readFileFromExternalStorage(Context context, String fileName)
            throws IOException {
        String fullPath = context.getExternalFilesDir(null) + "/" + fileName;
        return readFileWithFullPath(fullPath);
    }

    public static byte[] readFileWithFullPath(String filePath)
            throws IOException {
        byte[] byteArr;
        File file = new File(filePath);
        int size = (int) file.length();
        byteArr = new byte[size];
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(byteArr, 0, byteArr.length);
        bufferedInputStream.close();
        return byteArr;
    }

    public static String getInternalStoragePath(Context context) {
        return context.getFilesDir().toString();
    }

    public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        if (file != null && file.exists() && !file.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 当前文件夹中文件的绝对路径
     *
     * @param directory 文件夹路径
     * @return
     */
    public static String haveFileInDirectory(String directory) {
        String filePath = "";
        File dirFile = new File(directory);
        if (dirFile.exists() && dirFile.isDirectory()) {
            File[] childFiles = dirFile.listFiles();
            if (childFiles != null && childFiles.length > 0) {
                for (int i = 0; i < childFiles.length; i++) {
                    File child = childFiles[i];
                    if (child != null && child.isFile()) {
                        filePath = child.getAbsolutePath();
                        break;
                    }
                }

            }
        }
        return filePath;
    }



    public static boolean isFile(String filePath) {
        if (filePath != null) {
            if (new File(filePath).isFile()) {
                return true;
            }
        }
        return false;
    }

    public static void checkDirectory(File dir) {
        if (dir.exists()) {
            if (!dir.isDirectory() && !dir.delete() && !dir.mkdirs()) {
                throw new RuntimeException("create file(" + dir + ") fail.");
            }
        } else if (!dir.mkdirs()) {
            throw new RuntimeException("create file(" + dir + ") fail.");
        }
    }

    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

    @SuppressWarnings("resource")
    public static long getFileSizes(File f)
            throws Exception {
        long s = 0;
        if (f.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(f);
            s = fis.available();
        } else {
            f.createNewFile();
        }
        return s;
    }

    public static long getFileSize(File f)
            throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    public static String FormatFileSize(long fileS, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        String fileSizeString = "";
        if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        }
        if (fileSizeString.startsWith(".")) {
            fileSizeString = "0" + fileSizeString;
        }
        return fileSizeString;
    }

    public static String FormatFileSize(long fileS) {// 转换文件大小
        return FormatFileSize(fileS, "#");
    }

    public static String FormatByteToM(long fileS, String pattern) {// 转换文件大小
        if (TextUtils.isEmpty(pattern)) {
            pattern = "#.00";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        String s = df.format((double) fileS / 1048576) + "M";
        if (s.startsWith(".")) {
            s = "0" + s;
        }
        return s;
    }

    public static long getlist(File f) {// 递归求取目录文件个数
        long size = 0;
        File flist[] = f.listFiles();
        size = flist.length;
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getlist(flist[i]);
                size--;
            }
        }
        return size;
    }

    public static boolean copyFile(File fromFile, File toFile) {
        if (fromFile == null || !fromFile.exists()) {
            return false;
        }
        if (!fromFile.isFile()) {
            return false;
        }
        if (!fromFile.canRead()) {
            return false;
        }
        if (toFile == null) {
            return false;
        }
        if (!toFile.getParentFile().exists()) {
            toFile.getParentFile().mkdirs();
        }
        if (toFile.exists()) {
            toFile.delete();
        }
        try {
            FileInputStream fosfrom = new FileInputStream(fromFile);
            FileOutputStream fosto = new FileOutputStream(toFile);
            byte bt[] = new byte[1024];
            int c;
            while ((c = fosfrom.read(bt)) > 0) {
                fosto.write(bt, 0, c); //将内容写到新文件当中
            }
            fosfrom.close();
            fosto.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static boolean isGifFile(File file) {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int[] flags = new int[5];
            flags[0] = inputStream.read();
            flags[1] = inputStream.read();
            flags[2] = inputStream.read();
            flags[3] = inputStream.read();
            inputStream.skip(inputStream.available() - 1);
            flags[4] = inputStream.read();
            inputStream.close();
            return flags[0] == 71 && flags[1] == 73 && flags[2] == 70 && flags[3] == 56 && flags[4] == 0x3B;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//
//    public static boolean isFileCachedInDisk(String url) {
//        if (StringUtils.isNull(url)) {
//            return false;
//        }
//        File imageFile = ImageEngineKt.imageEngine.getDiskCache(url);
//        if (imageFile != null && imageFile.exists() && imageFile.length() > 0) {
//            return true;
//        }
//        return false;
//    }
//
//    public static String getPathByUrl(String url) {
//        if (StringUtils.isNull(url)) {
//            return "";
//        }
//        File imageFile = ImageEngineKt.imageEngine.getDiskCache(url);
//        if (imageFile != null && imageFile.exists() && imageFile.length() > 0) {
//            return imageFile.getPath();
//        }
//        return "";
//    }

    public static String formatFileSize(long size) {
        if (size >= 1024 * 1024) {
            return String.format("%.1f MB", size / (1024.0 * 1024.0));
        } else if (size >= 1024) {
            return String.format("%.1f KB", size / 1024.0);
        } else {
            return size + " B";
        }
    }


    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    /**
     * 解析响应头
     */
    public static String extractFileNameFromContentDisposition(String dispositionHeader) {
        if (dispositionHeader != null) {
            //文件名可能包含双引号，需要去除
            dispositionHeader = dispositionHeader.replaceAll("\"", "");
            String split = "filename=";
            int indexOf = dispositionHeader.indexOf(split);
            if (indexOf != -1) {
                String substringFilename = dispositionHeader.substring(indexOf + split.length(), dispositionHeader.length());
                try {
                    //兼容不加utf-8标识 其实是uft-8
                    substringFilename = URLDecoder.decode(substringFilename, StandardCharsets.UTF_8.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return substringFilename;
            }
            split = "filename*=";
            indexOf = dispositionHeader.indexOf(split);
            if (indexOf != -1) {
                String filename = dispositionHeader.substring(indexOf + split.length(), dispositionHeader.length());
                String encode = "UTF-8''";
                if (!filename.contains(encode)) {
                    encode = "utf-8''";
                }
                if (filename.startsWith(encode)) {
                    filename = filename.substring(encode.length(), filename.length());
                }
                return filename;
            }

            split = "filename";
            indexOf = dispositionHeader.indexOf(split);
            if (indexOf != -1 && dispositionHeader.contains("utf")) {
                String decodedString = null;
                try {
                    decodedString = URLDecoder.decode(dispositionHeader, StandardCharsets.UTF_8.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                String encode = "utf-8''";
                if (TextUtils.isEmpty(decodedString) || !decodedString.contains(encode)) {
                    return null;
                }
                return decodedString.substring(decodedString.indexOf(encode) + encode.length(), decodedString.length());

            }
        }
        return null;
    }


}
