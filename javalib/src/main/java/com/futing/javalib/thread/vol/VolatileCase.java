package com.futing.javalib.thread.vol;

/**
 * Created by futing on 2024/3/30.
 */
public class VolatileCase {

    private volatile static boolean ready;
    private volatile static int number;

    private  static class PrintThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("PrintThread is running .......");
            while (!ready) {//无限循环
                System.out.println("ready = "+ready);
                System.out.println("number = "+number);
            }
            System.out.println("end ready = "+ready);
            System.out.println("end number = "+number);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new PrintThread().start();
        Thread.sleep(1000);
        number = 51;
        ready = true;
        Thread.sleep(5000);
        System.out.println(" Main end");
    }

}
