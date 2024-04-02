package com.futing.javalib.thread.threadlocal;

/**
 * Created by futing on 2024/3/
 */
public class UseThreadLocal {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {

    };

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

        }
    }

    public static void main(String[] args) {

    }
}
