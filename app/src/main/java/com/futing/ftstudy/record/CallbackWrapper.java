package com.example.myapplication;

interface CallbackWrapper {
    void success(Object obj ,Object... params);
    void error(String msg);
}
