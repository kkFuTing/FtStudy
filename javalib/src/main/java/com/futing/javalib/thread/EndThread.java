package com.futing.javalib.thread;


/**
 * Created by futing on 2024/3/28.
 */
public class EndThread {

    //创建线程的方式
    public static void main(String[] args) throws InterruptedException {
        Thread endUseThread = new UseThread("endThread");
        endUseThread.start();
        Thread.sleep(20);
        endUseThread.interrupt(); //只是标识一个中断标志位，不会去中断进程 （发起中断）
    }

    //1、扩展自Thread类 （Thread 对线程的抽象）
    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "interrupt flag =" + isInterrupted());
            while (!Thread.currentThread().isInterrupted()) { //获取当前执行这一堆的代码的线程中断
//            while (!isInterrupted()) {
//            while (!Thread.interrupted()) { //用的不多（静态interrupted方法 返回也是Boolean值，也是检查当前中断为是不是true，但是执行该方法后会清除中断未标识，isInterrupted() 由true改成false）
//            while (true) {
                System.out.println(threadName + "is running");
                System.out.println(threadName + "inner interrupt flag=" + isInterrupted());
            }
            System.out.println(threadName + "interrupt flag = " + isInterrupted());
        }


    }
}