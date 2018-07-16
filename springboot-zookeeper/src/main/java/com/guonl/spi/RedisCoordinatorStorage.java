
package com.guonl.spi;

import com.guonl.enums.StorageEnum;
import com.guonl.utils.LogUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;

import java.util.Map;

/**
 * @ClassName: RedisCoordinatorStorage
 * @Description: redis实现
 * @author lenovo
 * @date 2018年6月20日
 * 
 */

public class RedisCoordinatorStorage implements CoordinatorStorage {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisCoordinatorStorage.class);

	private RedisTemplate redisTemplate;

	private ValueOperations<String, Object> vOps;

	@Override
	public void getInstance(Object template) {
		this.redisTemplate = (RedisTemplate<String, Object>) template;
		this.vOps = redisTemplate.opsForValue();
	}

	@Override
	public Boolean hasHashKey(final String map, String hashKey) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.hasKey(map, hashKey);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void setHashTable(String mapKey, Map<String, String> mapValue) {
		Object res = redisTemplate.execute(new SessionCallback() {
			@Override
			public Object execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				// operations.delete(mapKey);
				operations.opsForHash().putAll(mapKey, mapValue);
				Object val = operations.exec();
				return val;
			}
		});
		if (res == null) {
			LogUtils.error(LOGGER, "=== redis transaction fail, key is:{}", () -> mapKey);
			throw new RuntimeException("Redis transaction fail");
		}
	}

	@Override
	public Map<String, String> getHashTable(final String key) {
		try {
			HashOperations<String, String, String> operations = redisTemplate.opsForHash();
			return operations.entries(key);
		} catch (Exception e) {
			// LOGGER.warn("redis get Exception.", e);
		}
		return MapUtils.EMPTY_MAP;
	}

	@Override
	public Object getHashKey(final String map, String hashKey) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.get(map, hashKey);
	}

	@Override
	public void setHashKey(final String mapKey, String hashKey, String value) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		operations.put(mapKey, hashKey, value);
	}

	@Override
	public void updateHashKey(final String mapKey, String hashKey, String value) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		operations.putIfAbsent(mapKey, hashKey, value);
	}

	@Override
	public void removeHashKey(Object mapKey, Object[] hashKeys) {
		redisTemplate.opsForHash().delete(mapKey, hashKeys);
	}

	public void setKey(String key, String value) {
		vOps.set(key, value);
	}

	public void updateKey(String key, String newValue) {
		/*
		 * Object res = redisTemplate.execute(new SessionCallback() {
		 * 
		 * @Override public Object execute(RedisOperations operations) throws
		 * DataAccessException { operations.multi(); operations.delete(key);
		 * operations.opsForValue().set(key, newValue, 5, TimeUnit.MINUTES);
		 * Object val = operations.exec(); return val; } }); if (res == null) {
		 * LogUtils.error(LOGGER, "=== redis transaction fail, key is:{}", () ->
		 * key); throw new RuntimeException("Redis transaction fail"); }
		 */

		vOps.getAndSet(key, newValue);
	}

	public Object getKey(String key) {
		return vOps.get(key);
	}

	@Override
	public String getStorage() {
		return StorageEnum.REDIS.getStorage();
	}

}
