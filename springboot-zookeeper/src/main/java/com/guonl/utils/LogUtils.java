
package com.guonl.utils;

import org.slf4j.Logger;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @ClassName: LogUtils
 * @Description: log输出
 * @author lenovo
 * @date 2018年6月25日
 * 
 */

public class LogUtils {

	public static final LogUtils LOG_UTIL = new LogUtils();

	private LogUtils() {

	}

	public static LogUtils getInstance() {
		return LOG_UTIL;
	}

	/**
	 * debug 打印日志
	 *
	 * @param logger
	 *            日志
	 * @param format
	 *            日志信息
	 * @param supplier
	 *            supplier接口
	 */
	public static void debug(Logger logger, String format, Supplier<Object> supplier) {
		if (logger.isDebugEnabled()) {
			logger.debug(format, supplier.get());
		}
	}

	public static void debug(Logger logger, Supplier<Object> supplier) {
		if (logger.isDebugEnabled()) {
			logger.debug(Objects.toString(supplier.get()));
		}
	}

	public static void info(Logger logger, String format, Supplier<Object> supplier) {
		if (logger.isInfoEnabled()) {
			logger.info(format, supplier.get());
		}
	}

	public static void info(Logger logger, Supplier<Object> supplier) {
		if (logger.isInfoEnabled()) {
			logger.info(Objects.toString(supplier.get()));
		}
	}

	public static void error(Logger logger, String format, Supplier<Object> supplier) {
		if (logger.isErrorEnabled()) {
			logger.error(format, supplier.get());
		}
	}

	public static void error(Logger logger, Supplier<Object> supplier) {
		if (logger.isErrorEnabled()) {
			logger.error(Objects.toString(supplier.get()));
		}
	}

	public static void warn(Logger logger, String format, Supplier<Object> supplier) {
		if (logger.isWarnEnabled()) {
			logger.warn(format, supplier.get());
		}
	}

	public static void warn(Logger logger, Supplier<Object> supplier) {
		if (logger.isWarnEnabled()) {
			logger.warn(Objects.toString(supplier.get()));
		}
	}

}
