// IReceiveMsgListener.aidl
package com.ft.myaidlserver;
import com.ft.myaidlserver.bean.Msg;//AIDL 文件中的 import 并不会自动导入，需要开发者自行添加。

// Declare any non-default types here with import statements


interface IReceiveMsgListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onReceive(in Msg msg);
}