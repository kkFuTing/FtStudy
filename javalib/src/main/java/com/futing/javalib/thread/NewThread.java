package com.futing.javalib.thread;

/**
 * Created by futing on 2024/3/30.
 */
public class NewThread {

    private static UserThread userThread;

    private static class UseRunaBle implements Runnable {
        @Override
        public void run() {


        }
    }

    private static class UserThread extends Thread {
        @Override
        public void run() {
            super.run();

        }
    }

    public static void main(String[] args) {
        userThread = new UserThread();
        userThread.start(); //允许只能调用一次

        UseRunaBle useRunaBle = new UseRunaBle();
        new Thread(useRunaBle).start();

    }

    private void stop() {
        userThread.stop();//终止一个线程，强烈中断
        userThread.interrupt();//给线程一个中断标志位
    }


}
