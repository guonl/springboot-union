package com.guonl.dubbo.service.impl;

import com.guonl.dao.UserMapper;
import com.guonl.dubbo.service.UserDubboService;
import com.guonl.entity.User;
import com.guonl.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by guonl
 * Date 2018/5/3 上午10:40
 * Description:
 */
@Service("userDubboService")
public class UserDubboServiceImpl implements UserDubboService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        System.out.println("dubbo 任务开始 ……");
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public String asysnTest(String name) {
        try {
            // 模拟业务处理时间
            System.out.println("provider开始处理：" + DateTimeUtil.dateToStr(new Date(),DateTimeUtil.STANDARD_FORMAT));
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + name + DateTimeUtil.dateToStr(new Date(),DateTimeUtil.STANDARD_FORMAT);
    }
}
