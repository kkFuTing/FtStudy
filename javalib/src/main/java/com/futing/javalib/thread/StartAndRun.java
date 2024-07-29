package com.futing.javalib.thread;

/**
 * Created by futing on 2024/3/30.
 */
public class StartAndRun {
    public  static class ThreadRun extends Thread{
        @Override
        public void run() {
            super.run();
            //可以看做普通的方法调用
            int i =100;
            while (i > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" 's i is: "+i--);
            }
        }
    }

    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        threadRun.setName("threadRun");
//        threadRun.start(); //threadRun子线程

//        threadRun.start(); //threadRun子线程 无法连续开启两个start
        threadRun.run(); //主线程 run可以当一个普通的方法
    }

}

