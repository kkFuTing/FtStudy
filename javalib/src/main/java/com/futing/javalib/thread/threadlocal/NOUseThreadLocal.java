package com.futing.javalib.thread.threadlocal;

/**
 * Created by futing on 2024/3/30.
 */
public class NOUseThreadLocal {
    private static Integer count = new Integer(1);
    public static class TestThread implements Runnable {
        int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "RUN:start");
            count = count + id;
            System.out.println(Thread.currentThread().getName() + "::" + count);
//            threadLocal.remove();
        }
    }

    /**
     * 运行3个线程
     */
    public void  startThreadArray(){
        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new UseThreadLocal.TestThread(i));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();

        }
    }
    public static void main(String[] args) {
        UseThreadLocal useThreadLocal = new UseThreadLocal();
        useThreadLocal.startThreadArray();

    }
}
