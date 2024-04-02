package com.futing.javalib;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by futing on 2024/3/28.
 */
public class ThreadStudy {
    public static void main(String[] args) {
        //java 虚拟机线程系统的管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronizer信息，仅仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            //遍历线程信息，仅打印线程ID和线程名称信息
            System.out.println("["+threadInfo.getThreadId()+"] "
            +threadInfo.getThreadName()
            );
        }
    }
}
