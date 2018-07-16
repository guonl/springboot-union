
package com.guonl.spi;

import com.guonl.enums.StorageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 * @ClassName: ZookeeperCoordinatorStorage
 * @Description: zk实现
 * @author lenovo
 * @date 2018年6月25日
 * 
 */

public class ZookeeperCoordinatorStorage implements CoordinatorStorage {

	/**
	 * logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperCoordinatorStorage.class);

	@Override
	public String getStorage() {
		return StorageEnum.ZOOKEEPER.getStorage();
	}

	@Override
	public void getInstance(Object template1) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean hasHashKey(String mapKey, String hashKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHashTable(String key, Map<String, String> value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, String> getHashTable(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getHashKey(String map, String hashKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHashKey(String map, String hashKey, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateHashKey(String mapKey, String hashKey, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeHashKey(Object mapK, Object[] hashKeys) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setKey(String key, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateKey(String key, String newValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
