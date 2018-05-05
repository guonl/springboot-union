package com.guonl.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
    private Integer id;

    private String mobile;

    private Integer goodsId;

    private Integer num;

    private Date createTime;

    private Boolean delFlag;

    public Order(Integer id, String mobile, Integer goodsId, Integer num, Date createTime, Boolean delFlag) {
        this.id = id;
        this.mobile = mobile;
        this.goodsId = goodsId;
        this.num = num;
        this.createTime = createTime;
        this.delFlag = delFlag;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}