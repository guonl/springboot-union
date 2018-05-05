package com.guonl.future;

import java.util.concurrent.Callable;

/**
 * Created by guonl
 * Date 2018/5/3 上午9:44
 * Description: future的demo测试
 */
public class RealData implements Callable<String>{

    private String data;

    public RealData(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        try {
            // 模拟业务的处理过程
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }
}
