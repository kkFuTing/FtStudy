package com.futing.ftstudy.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ArrayRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.RawRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.core.content.ContextCompat;

import java.util.concurrent.atomic.AtomicInteger;

public class ResFinder {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF)
                newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    public static int resId(Context context, String defType, String name) {
        return context.getResources().getIdentifier(name, defType, context.getPackageName());
    }

    public static Drawable drawable(Context context, String name) {
        return ContextCompat.getDrawable(context, drawableId(context, name));
    }

    @DrawableRes
    public static int drawableId(Context context, String name) {
        return resId(context, "drawable", name);
    }

    public static Drawable mipmap(Context context, String name) {
        return ContextCompat.getDrawable(context, mipmapId(context, name));
    }

    @DrawableRes
    public static int mipmapId(Context context, String name) {
        return resId(context, "mipmap", name);
    }

    public static String string(Context context, String name) {
        return context.getString(stringId(context, name));
    }

    @StringRes
    public static int stringId(Context context, String name) {
        return resId(context, "string", name);
    }

    public static <T extends View> T findViewById(Context context, View view, String name) {
        return view.findViewById(viewId(context, name));
    }

    public static <T extends View> T findViewById(Activity activity, String name) {
        return activity.findViewById(viewId(activity, name));
    }

    @IdRes
    public static int viewId(Context context, String name) {
        return resId(context, "id", name);
    }

    public static View layout(Context context, String name) {
        return LayoutInflater.from(context).inflate(layoutId(context, name), null);
    }

    public static View layout(Context context, String name, ViewGroup root, boolean attachToRoot) {
        return LayoutInflater.from(context).inflate(layoutId(context, name), root, attachToRoot);
    }

    @LayoutRes
    public static int layoutId(Context context, String name) {
        return resId(context, "layout", name);
    }

    public int color(Context context, String name) {
        return ContextCompat.getColor(context, colorId(context, name));
    }

    @ColorRes
    public static int colorId(Context context, String name) {
        return resId(context, "color", name);
    }

    @ArrayRes
    public static int arrayId(Context context, String name) {
        return resId(context, "array", name);
    }

    @StyleRes
    public static int styleId(Context context, String name) {
        return resId(context, "style", name);
    }

    public static float dimen(Context context, String name) {
        return context.getResources().getDimension(dimenId(context, name));
    }

    @DimenRes
    public static int dimenId(Context context, String name) {
        return resId(context, "dimen", name);
    }

    @RawRes
    public static int rawId(Context context, String name) {
        return resId(context, "raw", name);
    }

    public static int integer(Context context, String name) {
        return context.getResources().getInteger(integerId(context, name));
    }

    @IntegerRes
    public static int integerId(Context context, String name) {
        return resId(context, "integer", name);
    }

    public static boolean bool(Context context, String name) {
        return context.getResources().getBoolean(boolId(context, name));
    }

    @BoolRes
    public static int boolId(Context context, String name) {
        return resId(context, "bool", name);
    }

    @StyleableRes
    public static int styleableId(Context context, String name) {
        return resId(context, "styleable", name);
    }
}
