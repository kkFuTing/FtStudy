package com.futing.javalib.guifan;

/**
 * Created by ting.fu on 2024/12/6.
 * {@link #postLogA} 用于发送日志。 //不知道为什么有些lib这样不行
 * {@link AnnotationShow#postLogA} 用于发送日志。
 *
 */
public class AnnotationShow {
    public void postLogA() {
        // 发送日志的实现
    }




    public class MyClass {
        /**
         * 这是一个方法
         * {@link #postLog} 用于发送日志。
         */
        public void myMethod() {
            // 方法实现
        }

        /**
         * 这是一个当前类的方法
         */
        public void postLog() {
            // 发送日志的实现
        }
    }

}
