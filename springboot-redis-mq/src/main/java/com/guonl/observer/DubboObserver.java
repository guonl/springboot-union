package com.guonl.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by guonl
 * Date 2018/6/26 下午12:46
 * Description: dubbo观察者
 */
@Component
public class DubboObserver extends Observer{

    @Autowired
    private DubboService dubboService;

    @Override
    public void update(String msg) {
        System.out.println("我是dubbo观察者，收到的消息是：" + msg);
        //调用dubbo接口
        dubboService.testDubbo();
    }
}
