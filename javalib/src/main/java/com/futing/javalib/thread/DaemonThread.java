package com.futing.javalib.thread;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

/**
 * Created by futing on 2024/3/30.
 */
public class DaemonThread {
    private static class UserThread extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                while (!isInterrupted()) {
                    System.out.println(Thread.currentThread().getName()+"while");
                }
                System.out.println("interrupt flag="+isInterrupted());
            } finally {

                //守护线程中打印finally 不一定执行，概率 看cpu有没有预留时间处理
                System.out.println("finally");
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
        UserThread userThread = new UserThread();
//        userThread.setPriority(10);//1~10
//        userThread.setPriority(1);
        userThread.setDaemon(true);//设置为守护线程
        userThread.start();
        Thread.sleep(5);
        userThread.interrupt();
    }
}
