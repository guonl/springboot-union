package com.guonl.cache;

import com.guonl.cache.base.CacheWorker;
import com.guonl.constant.CommonConstant;
import com.guonl.model.Goods;

import java.text.MessageFormat;

/**
 * Created by guonl
 * Date 2018/6/26 下午3:02
 * Description:
 */
public class GoodCacheWorker extends CacheWorker<Integer,Goods>{


    @Override
    protected Goods getDataWhenNoCache(Integer params) {
        //从DB查询
        return null;
    }

    @Override
    protected String getKey(Integer goodId) {
        String key = MessageFormat.format(CommonConstant.RedisKey.GOODS_INFO_BY_ID, goodId);
        return key;
    }

    @Override
    protected int getExpireSeconds() {
        return CommonConstant.RedisKeyExpireSeconds.GOODS_STORE_BY_ID;
    }
}
