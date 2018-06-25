package com.guonl.mq;

import com.guonl.constant.MessageType;
import org.springframework.stereotype.Component;
import wang.moshu.message.AbstarctMessageHandler;

import java.util.Random;

/**
 * Created by guonl
 * Date 2018/6/25 下午3:59
 * Description:
 */
@Component
public class MqHandler02 extends AbstarctMessageHandler<RedisMessage>{

    public MqHandler02() {
        super(MessageType.GOOD_MESSAGE, RedisMessage.class, Integer.MAX_VALUE);
    }

    @Override
    public void handle(RedisMessage redisMessage) {
        try {
            Thread.sleep(new Random().nextInt(100));
            System.out.println("消费者02：" + redisMessage.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleFailed(RedisMessage redisMessage) {
        System.out.println("超过重试次数，失败……");

    }
}
