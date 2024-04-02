package com.futing.javalib.algorithm.thread.syn;

/**
 * synchronized 的使用
 * Created by futing on 2024/3/30.
 */
public class SynTest {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void incCount() {
        count++;
    }

    //    用在方法上
    public synchronized void incCountBySynchronized() {
        count++;
    }


    Object object = new Object();

    //用在同步块上
    public void incCountByOBJ() {
        synchronized (object) {
            count++;
        }
    }
    //用在同步块上 但是是当前类的实例
    public void incCountByThis() {
        synchronized (this) {
            count++;
        }
    }

    private static class  CountThread extends Thread{
        private SynTest synTest;
        public CountThread(SynTest synTest){
            this.synTest = synTest;
        }
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 1000; i++) {
//                synTest.incCountByOBJ();
//                synTest.incCountBySynchronized();
                synTest.incCountByThis();
//                synTest.incCount();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SynTest synTest = new SynTest();
        CountThread countThread = new CountThread(synTest);
        countThread.start();
        new CountThread(synTest).start();
        Thread.sleep(50);
        System.out.println(synTest.getCount());

    }

}
