package com.guonl.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guonl
 * Date 2018/6/26 下午12:50
 * Description: 被观察者
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();//存储所有观察者对象

    public void setMsg(String msg) {
        notifyAll(msg);
    }

    //订阅
    public void addAttach(Observer observer) {
        observers.add(observer);
    }

    //通知所有订阅的观察者
    private void notifyAll(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
}
