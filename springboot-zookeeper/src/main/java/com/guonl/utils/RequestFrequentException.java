package com.guonl.utils;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author xinjian.wu
 * @date 2018-02-06
 */
public class RequestFrequentException extends RedstarException {

	public RequestFrequentException(int code, String message) {
		super(code, message);
	}

	public RequestFrequentException() {
		super(46020, "操作太频繁，稍后再试");
	}

	public RequestFrequentException(RequestFrequentEnum requestFrequentEnum) {
		super(requestFrequentEnum.getCode(), requestFrequentEnum.getMessage());
	}
}
