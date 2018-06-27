package com.guonl.observer;

/**
 * Created by guonl
 * Date 2018/6/26 下午12:44
 * Description: 需要被监听的方法
 */
public abstract class Observer {
    public abstract void update(String msg);
}
