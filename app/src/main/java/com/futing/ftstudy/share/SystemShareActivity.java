package com.futing.ftstudy.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.text.HtmlCompat;

import com.futing.ftstudy.R;

public class SystemShareActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_share_system);
    }

    public void bt_share_url(View view) {

//        share();
//        share1();
//        share2();
//        share3();
        share4();


    }

    private void share4() {
        String htmlText = "<html><body><h1>Hello, World!</h1><p>This is HTML text with a <a href=\"https://www.baidu.com/index.htm\">link</a> and an <img src=\"https://appcloud-static.mypaas.com.cn/plugin/futing/1.jpg\" alt=\"Icon\"></p></body></html>";

// 创建Intent
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/html");
        sendIntent.putExtra(Intent.EXTRA_HTML_TEXT, htmlText);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello, World! This is a link: https://www.baidu.com/index.htm");
        sendIntent.putExtra(Intent.EXTRA_TEXT, htmlText);

// 启动Intent
        startActivity(Intent.createChooser(sendIntent, "Send HTML"));

    }

    public String Body = "<div>Bonjour,</div><p><a href=\"https://www.google.fr\">Recherche</a></p><p>Fin</p>";

    //邮件
    private void share3() {
        Intent eMail = new Intent(android.content.Intent.ACTION_SEND);
        //eMail.setType("text/html");
        eMail.setType("message/rfc822");
        eMail.putExtra(Intent.EXTRA_EMAIL, "");
        eMail.putExtra(Intent.EXTRA_SUBJECT, "Test Link");
        eMail.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(Body));
        //eMail.putExtra(Intent.EXTRA_HTML_TEXT, Html.fromHtml(Body));
        startActivity(Intent.createChooser(eMail, "Select an eMail client"));
    }


    private void share2() {
        String htmlText = "<html><body><h1>Hello, World!</h1><p>This is HTML text with a <a href=\"https://developer.work.weixin.qq.com/document/path/90294\">link</a>.</p></body></html>";

// 创建Intent
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_HTML_TEXT, htmlText);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "AAAAAAAA");
        //显示的还是 EXTRA_TEXT的内容 和text/plain一样
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello, World! This is a link: https://developer.work.weixin.qq.com/document/path/90294");

// 启动Intent
        startActivity(Intent.createChooser(sendIntent, "Send HTML"));
    }

    private void share1() {
        String htmlText = "<html><body><h1>Hello, World!</h1><p>This is HTML text with a <a href=\"https://developer.work.weixin.qq.com/document/path/90294\">link</a>.</p></body></html>";

// 创建Intent
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/html");
        sendIntent.putExtra(Intent.EXTRA_HTML_TEXT, htmlText);
        //显示的还是 EXTRA_TEXT的内容 和text/plain一样
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello, World! This is a link: https://developer.work.weixin.qq.com/document/path/90294");

// 启动Intent
        startActivity(Intent.createChooser(sendIntent, "Send HTML"));
    }

    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
        intent.setType("text/html");
        //过滤包名
        intent.setPackage("com.tencent.mm");

        // 设置分享的文本内容，包含文字和链接
//        String text = "Check out this link:https://developer.work.weixin.qq.com/document/path/90294";
        String text = "https://developer.work.weixin.qq.com/document/path/90294";

        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.putExtra(Intent.EXTRA_SUBJECT, "text");
//        intent.putExtra(Intent.EXTRA_TEXT, text);

        startActivity(Intent.createChooser(intent, "分享链接到"));
    }
}
