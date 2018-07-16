package com.guonl.enums;

/**
 * @author lenovo
 *
 */
public enum RedisKeyEnum {

	KEY_security_space_prefix("uc:security:request"), KEY_security_ip("ip"), KEY_security_openid("openid");

	private String keys;

	RedisKeyEnum(String keys) {
		this.keys = keys;
	}

	public String getKeys() {
		return keys;
	}
}
