// IMyAidlInterface.aidl
package com.ft.myaidlserver;

// Declare any non-default types here with import statements

//步骤 1: 定义 AIDL 接口
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int add(int a, int b);
}