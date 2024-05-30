package com.futing.ftstudy.utils;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;


public class LanguageManger {


    /**
     * @param language en-US;zh-CN
     */
    public static void setLanguage(String language) {
        //意跟随系统语言可以传入null
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(language));
        // TODO: 2024/5/30
        //1.设置偏好会闪动
        //2.横屏到竖屏，或者竖屏到横屏会导致画面闪屏，具体见2-1和2-2
        //2-1.横屏开启-》竖屏 竖屏会销毁再创建两次  (LanguageActivity横屏 ->VerticalActivity 此时会创建销毁再创建) 此时回退到LanguageActivity横屏也会重新创建-》销毁-》创建导致闪退
        //2-2.竖屏开启-》横屏 横屏会销毁再创建两次  (LanguageActivity竖屏 ->LandscapeActivity 此时会创建销毁再创建) 此时回退到LanguageActivity横屏也会重新创建-》销毁-》创建导致闪退
    }
}
