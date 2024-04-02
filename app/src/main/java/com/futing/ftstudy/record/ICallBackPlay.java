package com.futing.ftstudy.record;

//单个播放
interface ICallBackPlay {
    void start();
    void error(Exception e);
    void finish();
}
