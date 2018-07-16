
package com.guonl.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lenovo
 *
 */
public enum StorageEnum {

	REDIS("redis"), ZOOKEEPER("zk");

	private String storage;

	StorageEnum(String storage) {
		this.storage = storage;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public static StorageEnum acquire(String storage) {
		Optional<StorageEnum> serializeEnum = Arrays.stream(StorageEnum.values())
				.filter(v -> Objects.equals(v.getStorage(), storage)).findFirst();
		return serializeEnum.orElse(StorageEnum.REDIS);
	}

}
