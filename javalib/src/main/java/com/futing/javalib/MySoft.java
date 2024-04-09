package com.futing.javalib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.UUID;

public class MySoft {
    public static void main(String[] args) {
        lecheng();
    }

    /**
     * 乐橙参数计算
     * appSecret 我未放在这里，这个需要找对应的配置信息（my的配置信息可以找自己浏览器文件夹【公司常用文件夹/硬件相关第三方配置(如乐橙).html】）；
     * 打开postman 将  time，nonce，sign替换其参数；将accessToken 替换demo就可以了。
     * @see <a href="https://open.imou.com/document/pages/c20750/#_4-http%E9%89%B4%E6%9D%83sign%E8%AE%A1%E7%AE%97%E8%AF%B4%E6%98%8E"></a>
     */
    public static void lecheng() {
        /**
         * 计算sign示例
         */
        // 1、获取当前时间戳 (该时间与真实时间误差不能超过5分钟)
        long currentTimeSeconds = System.currentTimeMillis()/1000;
        //原始计算例子
//        currentTimeSeconds = 1706511734;
        System.out.println(currentTimeSeconds);
        // 2、获取随机数
        String nonce = UUID.randomUUID().toString();
        System.out.println(nonce);
//        nonce = "f5a1ae2d-c09c-4d39-a744-83a5c2c653c2";
        // 3、appSecret请在控制台-应用信息中获取
        String appSecret = "";
        //原始计算例子
//        String appSecret = "test123456789test123456789";
        // 4、生成原始串
        String SIGN_TEMPLATE = MessageFormat.format("time:{0},nonce:{1},appSecret:{2}", currentTimeSeconds+"", nonce, appSecret);
//         SIGN_TEMPLATE = "time:1706511734,nonce:f5a1ae2d-c09c-4d39-a744-83a5c2c653c2,appSecret:test123456789test123456789";
        System.out.println(SIGN_TEMPLATE);
        // 5、计算sign
//        计算的结果为 fd37b62889e4757c58b8f3bf05fb9976 则正确
        String sign = calculateMD5(SIGN_TEMPLATE);
        System.out.println(sign);
    }

    public static String calculateMD5(String input) {
        try {
            // 创建 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算哈希值
            byte[] hash = md.digest(input.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // 返回 MD5 哈希值的十六进制表示
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
