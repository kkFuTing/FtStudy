package com.futing.ftstudy;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void md5(){
//        destFileName = String.format("%s_%s", downloadUrl.hashCode(), fileName);
//        destFileName = TextUtils.isEmpty(fileName) ? String.format("%s_%s", downloadUrl.hashCode(), "unknown"): fileName;
        String md5FromHeader = "WMzyT+UUKHm2ceZsOWOD9Q==";
        System.out.println(base64ToHex(md5FromHeader));
        verifyFile(null);
    }
    public static String getStringMd5(String str) {
        MessageDigest mdEncoder;
        try {
            mdEncoder = MessageDigest.getInstance("MD5");
            mdEncoder.update(str.getBytes(StandardCharsets.US_ASCII), 0, str.length());
            StringBuilder hexString = new StringBuilder();
            for (byte b : mdEncoder.digest()) {
                hexString.append(String.format("%02x", b&0xff));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
//            Log.d(TAG, "error form libwebviewext's verifyFile,md5FromHeader is null：" + md5FromHeader);
        }
        return null;
    }

    private boolean verifyFile(File file) {

        String md5FromHeader = null;
        String fileMD5 = "";
        String bytesToHex = "";
        if (fileMD5 != null &&
                (fileMD5.equals(md5FromHeader)
                        || fileMD5.equals(bytesToHex))) {
            // 文件完整
            return true;
        }
        return false;
    }
    public static String base64ToHex(String base64) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return bytesToHex(decodedBytes);
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    @Test
    public void testFileName() {
//        System.out.println(extractFileNameFromContentDisposition("attachment;   filename=%e5%8d%9a%e5%9b%ad122%e5%b9%b3%e6%a0%b7%e6%9d%bf%e9%97%b4.jpg"));
//        System.out.println(extractFileNameFromContentDisposition("attachment;   filename=博园122平样板间.jpg"));
//        System.out.println(extractFileNameFromContentDisposition("attachment;   filename=博园122平样板间.jpg"));
        System.out.println(extractFileNameFromContentDisposition("attachment; filename*=utf-8''%E5%AE%89%E5%85%A8%E5%8D%A1%E5%8E%8B%E7%BC%A9%E5%8C%85.zip"));

        System.out.println(getFileNameFromContentDisposition("attachment;   filename=%e5%8d%9a%e5%9b%ad122%e5%b9%b3%e6%a0%b7%e6%9d%bf%e9%97%b4.jpg"));
        System.out.println(getFileNameFromContentDisposition("attachment;   filename=博园122平样板间.jpg"));
        System.out.println(getFileNameFromContentDisposition("attachment;   filename=博园122平样板间.jpg"));
        System.out.println(getFileNameFromContentDisposition("attachment; filename*=utf-8''%E5%AE%89%E5%85%A8%E5%8D%A1%E5%8E%8B%E7%BC%A9%E5%8C%85.zip"));
    }
    public static String getFileNameFromContentDisposition(String contentDisposition)  {
        if (contentDisposition == null) {
            return null;
        }

        // Pattern to match the filename from the Content-Disposition header
        String fileNamePattern = "filename\\*?=([^;]+)";
        Pattern pattern = Pattern.compile(fileNamePattern);
        Matcher matcher = pattern.matcher(contentDisposition);

        if (matcher.find()) {
            String fileName = matcher.group(1);
            if (fileName.toLowerCase().startsWith("utf-8''")) {
                // Handle RFC 5987 encoding (UTF-8''encodedFilename)
                fileName = fileName.substring(7);
            }
            // //兼容不加utf-8标识 其实是uft-8编码了，所以都解码了
            try {
                fileName = URLDecoder.decode(fileName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
            }
            return fileName;
        }
        return null;
    }
    public static String getFileNameFromContentDisposition1(String contentDisposition) {
        if (contentDisposition == null) {
            return null;
        }

        // Pattern to match the filename from the Content-Disposition header
        String fileNamePattern = "filename\\*?=([^;]+)";
        Pattern pattern = Pattern.compile(fileNamePattern);
        Matcher matcher = pattern.matcher(contentDisposition);

        if (matcher.find()) {
            String fileName = matcher.group(1);
            if (fileName.toLowerCase().startsWith("utf-8''")) {
                fileName = fileName.substring(7);
                try {
                    fileName = URLDecoder.decode(fileName, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                // Remove any enclosing quotes if present
                if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
                    fileName = fileName.substring(1, fileName.length() - 1);
                }
            }
            return fileName;
        }
        return null;
    }

    /**
     * 解析响应头
     */
    public String extractFileNameFromContentDisposition(String dispositionHeader) {
        if (dispositionHeader != null) {
            //文件名可能包含双引号，需要去除
            dispositionHeader = dispositionHeader.replaceAll("\"", "");
            String split = "filename=";
            int indexOf = dispositionHeader.indexOf(split);
            if (indexOf != -1) {
                String substringFilename = dispositionHeader.substring(indexOf + split.length(), dispositionHeader.length());
                try {
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

    @Test
    public void testFilename255() {
        String filenamelength = "utf-8''xlsxlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xx%E6%96%87%E4%BB%B6.xlsx";
        System.out.println(filenamelength.length());
        String name = "xlsxlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xlsx%E6%96%87%E4%BB%B6xx%E6%96%87%E4%BB%B6.xlsx";
        try {
            String filename = URLDecoder.decode(name, "UTF-8");
            System.out.println(filename);
            System.out.println(filename.length());
            System.out.println("++++++++");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("===========");
        String fileName = "-1255583662_utf-8''xlsxlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xlsx文件xx文件.xlsx";
        System.out.println(fileName.length());
        System.out.println("--=======");
        String trimFileName = trimFileName(fileName);

        System.out.println(trimFileName);
        System.out.println(trimFileName.length());
    }

    //Linux系统中文件名长度不能超过255个字符！
    public String trimFileName(String fileName) {
        if (fileName.length() <= 255) {
            return fileName;
        }

        // 分割文件名和后缀名
        int extensionIndex = fileName.lastIndexOf('.');
        String name = fileName.substring(0, extensionIndex);
        String extension = fileName.substring(extensionIndex);

        // 如果文件名长度超过了 255 个字符，则截取前面 255 个字符
        if (name.length() > 255 - extension.length()) {
            name = name.substring(0, 255 - extension.length());
        }

        // 拼接文件名和后缀名
        return name + extension;
    }

    /**
     * work test
     * 获取文件目录的某个值
     */
    @Test
    public void getFileNameKey() {
        String ab = "/storage/emulated/0/Android/data/com.mysoft.fastplugin/files/mysoft/fast/event_log/event_log_9f7c76ff-c52e-48bd-93cd-32e49bc86d1cretry_count_1.zip";
//        Pattern p = Pattern.compile("(?<=retry_count_).*?(?=.zip)"); sonerlint会报红
        Pattern p = Pattern.compile("(?<=retry_count_).*(?=.zip)");
        Matcher m = p.matcher(ab);
        boolean delete = false;
        while (m.find()) {
            System.out.println("find");
            Integer retryCount = Integer.valueOf(m.group(0));
            System.out.println(retryCount);
            retryCount++;
            System.out.println(retryCount);
            String s = m.replaceFirst(retryCount + "");
            System.out.println(ab);
            System.out.println(s);
            System.out.println(String.format((delete ? "在文件数量达到 %d 个时，从最早创建的开始清理,删除文件成功" : "在文件数量达到%d个时，从最早创建的开始清理,删除文件失败"), retryCount));
        }
    }


    /**
     * 测试 for 到第五个的时候，return 会不会继续执行,
     */
    @Test
    public void checkForReturn() {

        String A = "AAAAAAA";
        System.out.println(A.length());
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println(i + ":return");
                return;
            }
            //i== 5 不会走
            System.out.println(i);
        }
        System.out.println("end");

    }

    /**
     * 获取标签连带链接
     */
    @Test
    public void getUrl() {
        String str = "<h3 class=\"t\"><a href=\"http://www.baidu.com/s?tn=baidurt&rtt=1&bsst=1&wd=%B3%C9%B6%BC%C3%C0%C5%AE\" target=\"_blank\"><em>成都美女</em>的最新相关信息</a><span class=\"tsuf tsuf-op\" data=\"{title : '', link : ''}\"></span></h3>";
        Pattern p = Pattern.compile("<a.*href=\"(.*?)\".*?>(.*?)</a>");
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group(1));
            System.out.println("-------");
            System.out.println(m.group(2));
        }
    }

    /**
     * 请使用 regularAPPIDFormWWWPath1
     */
    @Test
    public void regularAPPIDFormWWWPath() {
        System.out.println(getAppId());
        regularAPPIDFormWWWPath1();
    }

    private String getAppId() {
        String url = "android：files://apps_data/{app_id}/www/";
        String[] split = url.split("/www");
        if (split.length > 0) {
            String[] split1 = split[0].split("/");
            if (split1.length > 0) {
                return split1[split1.length - 1];
            }
        }
        return "error";
    }

    @Test
    public void regularAPPIDFormWWWPath1() {
        String a = "/(?<=apps_data/).+(?=/www)/";
        String url = "android：files://apps_data/{app_id}/www/";
        Pattern p = Pattern.compile("(?<=apps_data/).*?(?=/www)");
        Matcher m = p.matcher(url);
        if (m.find()) {
            System.out.println(m.group(0));
        }
    }

    @Test
    public void remove() {
        String data = "Your otp for the login is 7832. This code will expire at 12:43:09PM";
        String data1 =
//                "  module.exports.metadata = {\n" +"
                "module.exports.metadata = {\"com.mysoft.core\": \"3.4.1\",\"cordova-plugin-file\": \"6.0.2\",\"cordova-plugin-device\": \"2.0.4-dev\",\"com.mysoft.mdebugging\": \"1.1.7\",\"com.mysoft.mutils\": \"1.9.2\",\"com.mysoft.mfilemanager\": \"1.4.5\",\"com.mysoft.mdownloader\": \"1.5.5\",\"com.mysoft.maudioplayer\": \"1.0.0\",\"com.mysoft.mwebview\": \"1.7.0\",\"com.mysoft.mcordovawebview\": \"2.5.1\",\"com.mysoft.mwebviewplus\": \"1.0.0\",\"com.mysoft.wkwebview\": \"1.3.7\"}});";

        System.out.println(data1);
        String data2 = data1.replace("/[ \\n]/g", "");
        Pattern pattern = Pattern.compile("(\\d{4})");
        String regexp = "/module.exports.metadata=(.*?);/";
        Pattern pattern2 = Pattern.compile(regexp);

//   \d is for a digit
//   {} is the number of digits here 4.

        Matcher matcher = pattern.matcher(data);
        Matcher matcher2 = pattern2.matcher(data2);
        String val = "";
        if (matcher.find()) {
            val = matcher.group(0);  // 4 digit number
        }
        String val2 = "";
        if (matcher2.find()) {
            val2 = matcher2.group(0);  // 4 digit number
        }
        System.out.println(val);
        System.out.println(val2);
    }

    /**
     * @Test +testImplementation 'org.json:json:20240303'
     * 无法测试，需要的时候再下载吧
     */
    @Test
    public void JSONDeal() {
        System.out.println("开始");
        String str = "{\"title\":\"标题\",\"content\":\"内容\" ,\"isPush\":\"false\",\"isShow\":\"true\"}";
        try {
            JSONObject object = new JSONObject(str);
//            boolean isShow = object.optBoolean("isShow");
            boolean isShow = object.getBoolean("isShow");
            System.out.println(isShow);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}