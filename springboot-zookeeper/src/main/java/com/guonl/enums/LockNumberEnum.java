package com.guonl.enums;

/**
 * @author lenovo
 *
 */
public enum LockNumberEnum {

	KEY_security_lock_number5(5), KEY_security_lock_number10(10);

	private Integer keys;

	LockNumberEnum(Integer keys) {
		this.keys = keys;
	}

	public Integer getKeys() {
		return keys;
	}
}
