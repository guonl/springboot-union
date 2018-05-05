package com.guonl.service.impl;

import com.guonl.common.ServerResponse;
import com.guonl.dao.UserMapper;
import com.guonl.entity.User;
import com.guonl.entity.UserExample;
import com.guonl.service.UserService;
import com.guonl.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guonl
 * Date 2018/5/2 下午9:50
 * Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<List<UserVo>> getAllUser() {
        UserExample example = new UserExample();
        List<User> users = userMapper.selectByExample(example);
        List<UserVo> list = new ArrayList<>();
        for (User user : users) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            list.add(userVo);
        }
        return ServerResponse.createBySuccess(list);
    }
}
