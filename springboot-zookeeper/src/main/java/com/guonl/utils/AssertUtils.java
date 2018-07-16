
package com.guonl.utils;

/**
 * @ClassName: AssertUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lenovo
 * @date 2018年6月22日
 * 
 */

public class AssertUtils {

	private AssertUtils() {

	}

	public static void notNull(Object obj, String message) {
		if (obj == null) {
			throw new RequestFrequentException(-1, message);
		}
	}

	public static void notNull(Object obj) {
		if (obj == null) {
			throw new RequestFrequentException(-1, "argument invalid,Please check");
		}
	}

	public static void checkConditionArgument(boolean condition, String message) {
		if (!condition) {
			throw new RequestFrequentException(-1, message);
		}
	}

}
