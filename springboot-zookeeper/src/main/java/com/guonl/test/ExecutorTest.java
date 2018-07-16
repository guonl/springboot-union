package com.guonl.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by guonl
 * Date 2018/7/3 下午5:12
 * Description:
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            String name = Thread.currentThread().getName();
            System.out.println(name);
        });
    }
}
