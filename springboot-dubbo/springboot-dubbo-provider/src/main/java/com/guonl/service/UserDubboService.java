package com.guonl.service;

import com.guonl.entity.User;

/**
 * Created by guonl
 * Date 2018/5/3 上午10:39
 * Description:
 */
public interface UserDubboService {

    User getUserById(int id);

    String asysnTest(String name);
}
