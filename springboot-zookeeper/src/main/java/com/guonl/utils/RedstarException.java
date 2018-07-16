package com.guonl.utils;

public class RedstarException extends RuntimeException {
	private int code;

	public RedstarException(int code, String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
