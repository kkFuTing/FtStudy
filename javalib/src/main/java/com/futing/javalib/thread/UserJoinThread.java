package com.futing.javalib.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

/**
 * Created by futing on 2024/3/30.
 */
public class UserJoinThread {
    static class Goddess implements Runnable {
        private Thread thread;

        public Goddess() {
        }

        public Goddess(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println("女神开始打饭");
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(2000);//休眠2s
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("女神打完了");

            }
        }
    }

    static class GoddessBF implements Runnable {
        @Override
        public void run() {
            System.out.println("女神BF开始打饭");

            try {
                Thread.sleep(2000);//休眠2s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("女神BF打完");

        }
    }

    public static void main(String[] args) throws InterruptedException {

        GoddessBF goddessBF = new GoddessBF();
        Thread threadBF = new Thread(goddessBF);

        Goddess goddess = new Goddess(threadBF);//男朋友插队
//        Goddess goddess = new Goddess();
        Thread thread = new Thread(goddess);
        thread.start();

        threadBF.start();

        System.out.println("///ft开始打饭");
        thread.join(); //插队
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "ft 打完了了");

    }

}
