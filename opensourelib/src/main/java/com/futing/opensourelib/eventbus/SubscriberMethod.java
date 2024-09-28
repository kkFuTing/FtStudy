package com.futing.opensourelib.eventbus;

import java.lang.reflect.Method;

/**
 * Created by dusuijiang on 2018/10/17.
 */

public class SubscriberMethod {
    private Class<?> type;
    private Method method;
    private ThreadMode threadMode;

    public SubscriberMethod(Class<?> type, Method method) {
        this.type = type;
        this.method = method;
    }

    /**
     *
     * @param type 方法的参数
     * @param method 方法名称
     * @param threadMode 注解的值
     */
    public SubscriberMethod(Class<?> type, Method method, ThreadMode threadMode) {
        this.type = type;
        this.method = method;
        this.threadMode = threadMode;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ThreadMode getThreadMode() {
        return threadMode;
    }

    public void setThreadMode(ThreadMode threadMode) {
        this.threadMode = threadMode;
    }

    @Override
    public String toString() {
        return "SubscriberMethod{" +
                "type=" + type +
                ", method=" + method +
                ", threadMode=" + threadMode +
                '}';
    }
}
