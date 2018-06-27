package com.guonl.cache.base;

import com.guonl.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * Created by guonl
 * Date 2018/6/26 下午3:03
 * Description: JSON对象缓存工作器模板
 */
public abstract class CacheWorker<P,R> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisUtil redisUtil;

    public R get(P params,Class<R> clazz){
        // 获取key，由继承者拼接
        String key = getKey(params);
        Object res = getCache(key, clazz);

        // 如果缓存中存在，直接返回
        if (res != null) {
            if (logger.isDebugEnabled()) {//这个目的也是为了提高并发
                StringBuilder sb = new StringBuilder();
                sb.append("从redis获取数据 (key:{").append(key).append("})");

                logger.debug(sb.toString());
            }
            return (R) res;
        }

        if (logger.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("从redis获取数据失败(key:{").append(key).append("}), 准备从DB获取.");

            logger.debug(sb.toString());
        }

        // 否则去DB中取
        R dataFromDb = getDataWhenNoCache(params);
        // 回写cache
        if (dataFromDb != null) {
            setCache(getExpireSeconds(), key, dataFromDb);
        }
        return dataFromDb;
    }


    /**
     * set操作 设定缓存
     * @param expireSeconds
     * @param key
     * @param dataFromDb
     */
    protected void setCache(int expireSeconds, String key, R dataFromDb) {
        redisUtil.set(key, dataFromDb, expireSeconds);
    }

    /**
     * 获取缓存的对象
     * @param key
     * @param clazz
     * @param <R>
     * @return
     */
    protected <R> R getCache(String key, Class<R> clazz) {
        // 尝试获取缓存值
        return (R) redisUtil.get(key);
    }


    /**
     * 当获取不到缓存时，使用该方法去DB或其他途径取数据,参数一般是ID
     * @param params
     * @return
     */
    protected abstract R getDataWhenNoCache(P params);

    /**
     * 生成key
     * @param params
     * @return
     */
    protected abstract String getKey(P params);

    /**
     * 获取缓存时间
     * @return
     */
    protected abstract int getExpireSeconds();



}
