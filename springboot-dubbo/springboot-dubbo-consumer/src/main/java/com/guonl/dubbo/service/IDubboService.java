package com.guonl.dubbo.service;

import com.guonl.entity.User;

/**
 * Created by guonl
 * Date 2018/5/3 上午10:39
 * Description:
 */
public interface IDubboService {

    User getUserById(int id);

    String asysnTest(String name);
}
