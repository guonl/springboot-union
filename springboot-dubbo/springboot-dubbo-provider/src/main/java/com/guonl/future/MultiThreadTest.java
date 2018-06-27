package com.guonl.future;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by guonl
 * Date 2018/5/3 上午10:02
 * Description: 线程池
 */
public class MultiThreadTest {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world !");
            }
        });
        System.out.println(" ===> main Thread! ");
    }
}
