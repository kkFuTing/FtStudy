package com.futing.myjetpack.livedatademo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//livedata使用步骤一：继承一个ViewModel  (ViewModel包了一个livedata)
public class NameViewModel extends ViewModel {
    //livaData的子类 MutableLiveData  一般用它的子类
    //显示一个人的名字
    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }
}
