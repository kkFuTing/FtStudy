package com.futing.ftstudy.language;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.futing.ftstudy.R;
import com.futing.ftstudy.utils.LanguageManger;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    private TextView mTVShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        mTVShow = findViewById(R.id.tv_tip);
    }

    public void goNextActivity(View view) {
        startActivity(new Intent(this, VerticalActivity.class));
    }

    public void btSettingEn(View view) {
        String language = Locale.ENGLISH.getLanguage();
        LanguageManger.setLanguage(Locale.ENGLISH.getLanguage());
        Toast.makeText(this, getText(R.string.language_setting_en)+"::"+language, Toast.LENGTH_SHORT).show();
    }

    public void btSettingCn(View view) {
        String language = Locale.CHINA.getLanguage();
        LanguageManger.setLanguage(Locale.CHINA.getLanguage());
        Toast.makeText(this, getText(R.string.language_setting_cn)+"::"+language, Toast.LENGTH_SHORT).show();
    }

    public void btSettingVerticalOrLandscape(View view) {
        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            mTVShow.setText(R.string.vertical_tip);
        } else if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            mTVShow.setText(R.string.landscape_tip);
        }
    }

    public void toVerticalAct(View view) {
        startActivity(new Intent(this, VerticalActivity.class));
    }

    public void toLandScapeAct(View view) {
        startActivity(new Intent(this, LandscapeActivity.class));
    }
}