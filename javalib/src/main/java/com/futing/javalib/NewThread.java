package com.futing.javalib;

/**
 * Created by futing on 2024/3/28.
 */
public class NewThread {
    //1、扩展自Thread类 （Thread 对线程的抽象）
    private static class UseThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("use  Thread");
        }
    }

    //2、实现Runnable接口 （Thread 对任务的抽象或说是对任务逻辑的抽象）
    private  static  class  UseRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("use  Runnable");

        }
    }


    //创建线程的方式
    public static void main(String[] args) {

        UseThread useThread = new UseThread();
        useThread.start();

        UseRunnable useRunnable = new UseRunnable();
        new Thread(useRunnable).start();
    }
}
