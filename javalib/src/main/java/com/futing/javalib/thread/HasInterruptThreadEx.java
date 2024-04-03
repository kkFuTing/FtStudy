package com.futing.javalib.thread;


/**
 * Created by futing on 2024/3/28.
 * 中断异常
 */
public class HasInterruptThreadEx {

    //创建线程的方式
    public static void main(String[] args) throws InterruptedException {
        Thread endUseThread = new UseThread("HasInterruptThreadEx");
        endUseThread.start();
        Thread.sleep(500);
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
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //抛出中断异常后，会标志位 会由true改成false
                    System.out.println(Thread.currentThread().getName() + ": interrupt flag is /" + isInterrupted());
                    //修改为false 是为了 给我们时间释放资源，再决定是否中断
                    interrupt();//需要手动再调用一次中断才可以中断
                    e.printStackTrace();
                }
                System.out.println(threadName + "interrupt flag = " + isInterrupted());
            }
        }


    }
}