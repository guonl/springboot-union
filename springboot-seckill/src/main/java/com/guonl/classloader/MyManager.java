package com.guonl.classloader;

/**
 * Created by guonl
 * Date 2018/5/5 下午4:32
 * Description:
 */
public class MyManager implements BaseManager{

    @Override
    public void logic() {
        System.out.println("我的一个自定义类加载……");
    }
}
