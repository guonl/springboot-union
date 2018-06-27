package com.guonl.intercept;

import com.guonl.constant.CommonConstant;
import com.guonl.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by guonl
 * Date 2018/6/26 下午3:58
 * Description: 黑名单缓存
 */
@Component
public class UserBlackListCache {
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 增加进入黑名单
     * @param mobile
     */
    public void addInto(String mobile) {
        redisUtil.hset(CommonConstant.RedisKey.USER_BLACK_LIST, mobile, "");
    }

    /**
     * 是否在黑名单中
     * @param mobile
     * @return
     */
    public boolean isIn(String mobile) {
        return redisUtil.hget(CommonConstant.RedisKey.USER_BLACK_LIST, mobile) != null;
    }
}
