package com.futing.javalib.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by futing on 2024/7/3.
 */
public class OnlyMain {

    public static void main(String[] args) {
        //虚拟机线程系统的管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步到的monitor和synchronied信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId()+"/"+threadInfo.getThreadName());
        }
    }
}
