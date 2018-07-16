
package com.guonl.utils;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName: ServiceBootstrapUtils
 * @Description: spi load
 * @author lenovo
 * @date 2018年6月20日
 * 
 */

public class ServiceBootstrapUtils {

	public static <S> S loadFirst(Class<S> clazz) {
		final ServiceLoader<S> loader = loadAll(clazz);
		final Iterator<S> iterator = loader.iterator();
		if (!iterator.hasNext()) {
			throw new IllegalStateException(String.format(
					"No implementation defined in /META-INF/services/%s, please check whether the file exists and has the right implementation class!",
					clazz.getName()));
		}
		return iterator.next();
	}

	public static <S> ServiceLoader<S> loadAll(Class<S> clazz) {
		return ServiceLoader.load(clazz);
	}
}
