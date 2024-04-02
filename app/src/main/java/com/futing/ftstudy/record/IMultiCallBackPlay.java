package com.futing.ftstudy.record;

interface IMultiCallBackPlay  {
    void start();
    void progress(String path,int current, int total);
    void error(String path,Exception e);
    void finish();
}
