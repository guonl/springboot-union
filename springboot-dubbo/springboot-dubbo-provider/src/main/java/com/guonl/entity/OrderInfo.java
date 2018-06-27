package com.guonl.entity;

import java.util.Date;

public class OrderInfo {

    private Integer orderId;

    private String orderSn;

    private Integer userId;

    private Integer channelsId;

    private String orderName;

    private Date orderTime;

    public OrderInfo(Integer orderId, String orderSn, Integer userId, Integer channelsId, String orderName, Date orderTime) {
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.userId = userId;
        this.channelsId = channelsId;
        this.orderName = orderName;
        this.orderTime = orderTime;
    }

    public OrderInfo() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChannelsId() {
        return channelsId;
    }

    public void setChannelsId(Integer channelsId) {
        this.channelsId = channelsId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}