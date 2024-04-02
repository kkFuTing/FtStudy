package com.futing.ftstudy.record;

interface CallbackWrapper {
    void success(Object obj ,Object... params);
    void error(String msg);
}
