package com.futing.javalib.thread.threadlocal;

/**
 * Created by futing on 2024/3/
 */
public class UseThreadLocal {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };//初始化为1

    public static class TestThread implements Runnable {
        int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "RUN:start");
            Integer s = threadLocal.get();
            s = s + id;
            threadLocal.set(s);
            System.out.println(Thread.currentThread().getName() + "::" + threadLocal.get());
//            threadLocal.remove();

        }
    }

    /**
     * 运行3个线程
     */
    public void  startThreadArray(){
        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new TestThread(i));
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
