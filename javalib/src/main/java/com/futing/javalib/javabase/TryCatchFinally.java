package com.futing.javalib.javabase;

/**
 * Created by futing on 2024/6/21.
 */
public class TryCatchFinally {
    public static void main(String[] args) {

//        try {
//            System.out.println("try");
//            System.exit(0);
//        } catch (Exception e) {
//            System.out.println("catch:" + e.getMessage());
//        } finally {
//            System.out.println("finally");
//        }

        System.out.println("=================");
        System.out.println(Thread.currentThread().getName());
        final int[] a = {9};
        final Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    a[0] = 10;
                    System.out.println("try:"+Thread.currentThread().getName());//finally不会执行
                    System.out.println("try:"+a[0]);
//                    System.out.println("try:");//这样写//设为守护进程,finally会执行,但是我发现怎么还执行了 多试了几次又执行啦
                    return;
                } catch (Exception e) {
                    System.out.println("catch:" + e.getMessage());
                } finally {
                    a[0] = 11;
                    //资料上说设为守护进程,finally不会执行,但是我发现怎么还执行了
                    System.out.println("finally");
                    System.out.println("finally:"+a[0]);

                }
                System.out.println("run:"+a[0]);

            }
        };
        thread.setDaemon(true);//设为守护进程
        thread.start();
        System.out.println("out:"+a[0]);
    }
}
