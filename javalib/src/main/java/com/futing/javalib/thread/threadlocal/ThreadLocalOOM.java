package com.futing.javalib.thread.threadlocal;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by futing on 2024/3/30.
 */
public class ThreadLocalOOM {
    private static final int TASK_LOOP_SIZE = 500;
    final static ThreadPoolExecutor poolExe
            = new ThreadPoolExecutor(5, 5, 1
            , TimeUnit.MINUTES,  new LinkedBlockingQueue());


    public static void main(String[] args) {


    }
}
