package com.futing.ftstudy.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Created by futing on 2024/6/22.
 */
public class TestBean implements Parcelable {
    private String name;
    private String pwd;

    public TestBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    //反序列化
    protected TestBean(Parcel in) {
        //按顺序读取
        name = in.readString();
        pwd = in.readString();
    }

    public static final Creator<TestBean> CREATOR = new Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel in) {
            return new TestBean(in);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    //序列化
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(pwd);
    }
}
