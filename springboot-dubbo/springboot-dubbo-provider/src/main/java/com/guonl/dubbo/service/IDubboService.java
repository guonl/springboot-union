package com.guonl.dubbo.service;

import com.guonl.entity.User;

/**
 * Created by guonl
 * Date 2018/6/27 下午2:23
 * Description:
 */
public interface IDubboService {

    User getUserById(int id);

    String asysnTest(String name);

}
