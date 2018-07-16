package com.guonl.utils;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author xinjian.wu
 * @date 2018-02-06
 */
public enum RequestFrequentEnum {

	REQUEST_SYS_ERROR(-1, "系统异常"), REQUEST_IP_LOCKED(46021, "系统正忙，请稍后再试"), REQUEST_USER_LOCKED(46022,
			"操作太频繁，请稍后再试"), REQUEST_USER_ERROR(46023, "用户异常");

	private Integer code;
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	RequestFrequentEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
