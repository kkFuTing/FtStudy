package com.ft.myaidlserver.server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteCallbackList
import android.util.Log
import com.ft.myaidlserver.IMsgManager
import com.ft.myaidlserver.IReceiveMsgListener
import com.ft.myaidlserver.bean.Msg

class MyService : Service() {

    private val receiveListeners = RemoteCallbackList<IReceiveMsgListener>()

    companion object {
        const val TAG = "MyService"
    }

    override fun onBind(intent: Intent): IBinder {
        return MyBinder()
    }

    inner class MyBinder : IMsgManager.Stub() {
        override fun sendMsg(msg: Msg?) {
            // server process request at here
        }

        override fun registerReceiveListener(listener: IReceiveMsgListener?) {
            receiveListeners.register(listener)
        }

        override fun unregisterReceiveListener(listener: IReceiveMsgListener?) {
            val success = receiveListeners.unregister(listener)
            if (success) {
                Log.d(TAG, "解除注册成功")
            } else {
                Log.d(TAG, "解除注册失败")
            }
        }
    }
}
