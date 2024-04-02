package com.futing.javalib.algorithm.thread.syn;

/**
 * Created by futing on 2024/3/30.
 */
public class TestIntegerSyn {
    public static void main(String[] args) {
        Worker worker = new Worker(1);
        for (int i = 0; i < 5; i++) {
            new Thread(worker).start();
        }
    }

    private static class Worker implements Runnable {

        private Integer i;

        Object o =new Object();
        public Worker(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (o) {
//            synchronized (this) {
//            synchronized (i) {//锁不住，因为i会改变。
                String name = Thread.currentThread().getName();
                System.out.println(name + ":i++前 ==" + i + "==@" + System.identityHashCode(i));

                i++;
                System.out.println(name + ":i==" + i + "==@" + System.identityHashCode(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
