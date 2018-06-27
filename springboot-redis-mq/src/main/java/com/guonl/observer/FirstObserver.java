package com.guonl.observer;

/**
 * Created by guonl
 * Date 2018/6/26 下午12:46
 * Description: 观察者一
 */
public class FirstObserver extends Observer{
    @Override
    public void update(String msg) {
        System.out.println("我是第一个观察者，收到的消息是：" + msg);
    }
}
