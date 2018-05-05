package com.guonl.entity;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable{
    private Integer id;

    private String name;

    private String randomName;

    private Integer store;

    private Date startTime;

    private Date endTime;

    private Integer version;

    private Boolean delFlag;

    public Goods(Integer id, String name, String randomName, Integer store, Date startTime, Date endTime, Integer version, Boolean delFlag) {
        this.id = id;
        this.name = name;
        this.randomName = randomName;
        this.store = store;
        this.startTime = startTime;
        this.endTime = endTime;
        this.version = version;
        this.delFlag = delFlag;
    }

    public Goods() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRandomName() {
        return randomName;
    }

    public void setRandomName(String randomName) {
        this.randomName = randomName == null ? null : randomName.trim();
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}