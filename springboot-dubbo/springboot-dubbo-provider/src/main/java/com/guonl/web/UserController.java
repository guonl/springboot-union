package com.guonl.web;

import com.guonl.common.ServerResponse;
import com.guonl.service.UserService;
import com.guonl.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by guonl
 * Date 2018/5/2 下午9:43
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ServerResponse<List<UserVo>> getAllUser(){
        ServerResponse<List<UserVo>> serverResponse = userService.getAllUser();
        return serverResponse;
    }



}
