package com.guonl.mq;

import java.io.Serializable;

/**
 * Created by guonl
 * Date 2018/6/25 下午3:59
 * Description:
 */
public class RedisMessage implements Serializable{

    private String mobile;

    private String goodName;

    public RedisMessage(String mobile, String goodName) {
        this.mobile = mobile;
        this.goodName = goodName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Override
    public String toString() {
        return "message{" +
                "mobile='" + mobile + '\'' +
                ", goodName='" + goodName + '\'' +
                '}';
    }
}
