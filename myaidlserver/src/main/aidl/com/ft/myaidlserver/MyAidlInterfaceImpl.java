package com.ft.myaidlserver;

import android.os.RemoteException;

/**
 * Created by ting.fu on 2025/3/6.
 * CH
 */
public class MyAidlInterfaceImpl extends IMyAidlInterface.Stub{
    @Override
    public int add(int a, int b) throws RemoteException {
        return 0;
    }
}
