package com.guonl.web;

import com.alibaba.dubbo.rpc.RpcContext;
import com.guonl.dubbo.service.UserDubboService;
import com.guonl.entity.User;
import com.guonl.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by guonl
 * Date 2018/5/3 上午11:01
 * Description:
 */
@RestController
@RequestMapping("/dubbo")
public class UserDubboController {

    @Autowired
    private UserDubboService userDubboService;


    @ResponseBody
    @RequestMapping(value = "/getuser/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id){
        User user = userDubboService.getUserById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/asyn01/{name}",method = RequestMethod.GET)
    public String asysn(@PathVariable String name){
        userDubboService.asysnTest(name);// 异步调用
        // 使用future模式实现异步调用
        Future<String> future = RpcContext.getContext().getFuture();
        try {
            String callback = future.get();// 这里传超时时间
            System.out.println(callback);// 打印带上时间戳
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "finish " + DateTimeUtil.dateToStr(new Date(),DateTimeUtil.STANDARD_FORMAT);
    }

    // 参看文章：https://www.cnblogs.com/java-zhao/p/8424019.html
    @ResponseBody
    @RequestMapping(value = "/asyn02/{name}",method = RequestMethod.GET)
    public String asysn02(@PathVariable String name){
        /**
         * 第二种方式实现
         */
        Future<String> future = RpcContext.getContext().asyncCall(() -> userDubboService.asysnTest(name));
        try {
            String callback = future.get();
            System.out.println(callback);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "finish " + DateTimeUtil.dateToStr(new Date(),DateTimeUtil.STANDARD_FORMAT);
    }

    @ResponseBody
    @RequestMapping(value = "/test/{name}",method = RequestMethod.GET)
    public String getUserById(@PathVariable String name){
        return name;
    }
}
