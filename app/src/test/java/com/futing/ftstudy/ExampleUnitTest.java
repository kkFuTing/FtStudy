package com.futing.ftstudy;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

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
     *     @Test
     *     +testImplementation 'org.json:json:20240303'
     *     无法测试，需要的时候再下载吧
     */
    @Test
    public void JSONDeal(){
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