package com.guonl.vo;

import java.io.Serializable;

/**
 * Created by guonl
 * Date 2018/5/6 上午11:36
 * Description: 返回数据类型
 */
public class ResultVo <T> implements Serializable {

    private boolean success;

    private T data;

    private String error;

    public ResultVo(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ResultVo(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
