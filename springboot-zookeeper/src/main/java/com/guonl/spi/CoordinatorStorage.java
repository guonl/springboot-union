
package com.guonl.spi;

import java.util.Map;

/**
 * @author lenovo
 *
 */
public interface CoordinatorStorage {
	/**
	 * @Title: getStorage @Description: TODO(这里用一句话描述这个方法的作用) @param @return
	 *         参数 @return String 返回类型 @throws
	 */

	String getStorage();

	/**
	 * @Title: getInstance @Description: TODO(这里用一句话描述这个方法的作用) @param @param
	 *         template 参数 @return void 返回类型 @throws
	 */

	void getInstance(Object template);

	/**
	 * @param mapKey
	 * @param hashKey
	 * @return
	 */
	Boolean hasHashKey(final String mapKey, String hashKey);

	/**
	 * 创建对象
	 * 
	 * @param map
	 * @return
	 */
	void setHashTable(String key, Map<String, String> value);

	/**
	 * @param key
	 * @return
	 */
	Map<String, String> getHashTable(final String key);

	/**
	 * @param hashKey
	 * @return
	 */
	Object getHashKey(final String map, String hashKey);

	/**
	 * @param redisTemplate
	 * @param map
	 * @param hashKey
	 * @param value
	 */
	void setHashKey(final String map, String hashKey, String value);

	/**
	 * @Title: updateHashKey @Description: TODO(这里用一句话描述这个方法的作用) @param @param
	 *         mapKey @param @param hashKey @param @param value 参数 @return void
	 *         返回类型 @throws
	 */

	void updateHashKey(final String mapKey, String hashKey, String value);

	/**
	 * 删除对象
	 *
	 * @param hashKey
	 * 
	 */
	void removeHashKey(Object mapK, Object[] hashKeys);

	void setKey(String key, String value);

	void updateKey(String key, String newValue);

	Object getKey(String key);

}
