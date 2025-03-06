// IMsgManager.aidl
package com.ft.myaidlserver;
import com.ft.myaidlserver.bean.Msg;
import com.ft.myaidlserver.IReceiveMsgListener;
// Declare any non-default types here with import statements

interface IMsgManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
  	// 发消息
    void sendMsg(in Msg msg);
  	// 客户端注册监听回调
    void registerReceiveListener(IReceiveMsgListener listener);
  	// 客户端取消监听回调
    void unregisterReceiveListener(IReceiveMsgListener listener);

}