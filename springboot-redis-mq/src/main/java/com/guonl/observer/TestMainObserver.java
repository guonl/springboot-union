package com.guonl.observer;

/**
 * Created by guonl
 * Date 2018/6/26 下午12:52
 * Description: 测试方法
 */
public class TestMainObserver {

    public static void main(String[] args) {
        FirstObserver first = new FirstObserver();
        SecondObserver second = new SecondObserver();
        ThirdObserver third = new ThirdObserver();
        DubboObserver dubbo = new DubboObserver();
        Subject subject = new Subject();
        subject.addAttach(first);
        subject.addAttach(second);
        subject.addAttach(third);
        subject.addAttach(dubbo);
        subject.setMsg("这是一个观察者模式");
    }
}
