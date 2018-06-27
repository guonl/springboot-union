package com.guonl.controller;

import com.guonl.constant.MessageType;
import com.guonl.mq.RedisMessage;
import com.guonl.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wang.moshu.message.Message;
import wang.moshu.message.MessageTrunk;

/**
 * Created by guonl
 * Date 2018/6/25 下午4:23
 * Description:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MessageTrunk messageTrunk;

    @ResponseBody
    @RequestMapping(value = "/mq/{message}",method = RequestMethod.GET)
    public String test(@PathVariable String message){

        for(int i=0;i<100;i++){
            RedisMessage redisMessage = new RedisMessage("1820000000"+i,"iphone"+i);
            Message message1 = new Message(MessageType.GOOD_MESSAGE,redisMessage);
            messageTrunk.put(message1);
        }
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user(@RequestParam(value = "mobile") String mobile){

        return mobile;
    }


}
