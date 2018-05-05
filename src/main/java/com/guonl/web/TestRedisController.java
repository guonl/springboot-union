package com.guonl.web;

import com.guonl.redis.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by guonl
 * Date 2018/5/2 下午3:51
 * Description:
 */
@RestController
@RequestMapping("/redis")
public class TestRedisController {

    private static final String KEY_PRE = "guonl:";

    @Autowired
    private RedisTemplate redisTemplate;

//    redisTemplate.opsForValue();//操作字符串
//    redisTemplate.opsForHash();//操作hash
//    redisTemplate.opsForList();//操作list
//    redisTemplate.opsForSet();//操作set
//    redisTemplate.opsForZSet();//操作有序set

    @RequestMapping("/put/{value}")
    public String index(@PathVariable String value) {
        redisTemplate.opsForValue().set(value,value,1000, TimeUnit.SECONDS);
        return value;
    }

    @RequestMapping("/lock/{id}")
    public Boolean lock(@PathVariable String id) {
        RedisLock redisLock = new RedisLock();
        String redisKey = KEY_PRE + id;
        boolean b = redisLock.tryGetDistributedLock(redisKey, id, 1000 * 60);
        return b;
    }

    @RequestMapping("/unlock/{id}")
    public Boolean unlock(@PathVariable String id) {
        RedisLock redisLock = new RedisLock();
        String redisKey = KEY_PRE + id;
        boolean b = redisLock.releaseDistributedLock(redisKey,id);
        return b;
    }


}
