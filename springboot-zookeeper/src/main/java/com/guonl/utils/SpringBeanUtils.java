
package com.guonl.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @ClassName: SpringBeanUtils
 * @Description: spring bean
 * @author lenovo
 * @date 2018年6月25日
 * 
 */

public class SpringBeanUtils {
	/**
	 * logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBeanUtils.class);
	private ConfigurableApplicationContext cfgContext;
	/**
	 * 实体对象
	 */
	private static final SpringBeanUtils INSTANCE = new SpringBeanUtils();

	private SpringBeanUtils() {
		if (INSTANCE != null) {
			throw new Error("spring bean error");
		}
	}

	public static SpringBeanUtils getInstance() {
		return INSTANCE;
	}

	/**
	 * 防止序列化产生对象
	 *
	 * @return 防止序列化
	 */
	private Object readResolve() {
		return INSTANCE;
	}

	/**
	 * 获取一个Bean信息
	 *
	 * @param type
	 *            类型
	 * @param <T>
	 *            泛型
	 * @return 对象
	 */
	public <T> T getBean(Class<T> type) {
		AssertUtils.notNull(type);
		return cfgContext.getBean(type);
	}

	/**
	 * 获取bean的名字
	 *
	 * @param type
	 *            类型
	 * @return bean名字
	 */
	public String getBeanName(Class type) {
		AssertUtils.notNull(type);
		return cfgContext.getBeanNamesForType(type)[0];
	}

	/**
	 * 判断一个bean是否存在Spring容器中.
	 *
	 * @param type
	 *            类型
	 * @return 成功 true 失败 false
	 */
	public boolean exitsBean(Class type) {
		AssertUtils.notNull(type);
		return cfgContext.containsBean(type.getName());
	}

	/**
	 * 动态注册一个Bean动Spring容器中
	 *
	 * @param beanName
	 *            名称
	 * @param beanClazz
	 *            定义bean
	 */
	public void registerBean(String beanName, Class beanClazz, Map<String, Object> propertys) {
		AssertUtils.notNull(beanName);
		AssertUtils.notNull(beanClazz);
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClazz);
		if (propertys != null) {
			propertys.forEach((k, v) -> builder.addPropertyValue(k, v));
		}
		builder.setScope(BeanDefinition.SCOPE_SINGLETON);
		registerBean(beanName, builder.getBeanDefinition());

	}

	public void registerBean(String beanName, Object obj) {
		AssertUtils.notNull(beanName);
		AssertUtils.notNull(obj);
		cfgContext.getBeanFactory().registerSingleton(beanName, obj);
	}

	/**
	 * 注册Bean信息
	 *
	 * @param beanDefinition
	 */
	public void registerBean(String beanName, BeanDefinition beanDefinition) {
		BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) cfgContext.getBeanFactory();
		beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
	}

	/**
	 * 根据枚举类型获取Spring注册的Bean
	 *
	 * @param annotationType
	 *            枚举
	 * @return
	 */
	public Map<String, Object> getBeanWithAnnotation(Class<? extends Annotation> annotationType) {
		AssertUtils.notNull(annotationType);
		return cfgContext.getBeansWithAnnotation(annotationType);
	}

	/**
	 * 动态注册一个Bean动Spring容器中
	 *
	 * @param beanName
	 *            名称
	 * @param beanClazz
	 *            定义bean
	 */
	public void registerBean(String beanName, Class beanClazz) {
		registerBean(beanName, beanClazz, null);
	}

	public void setCfgContext(ConfigurableApplicationContext cfgContext) {
		this.cfgContext = cfgContext;
	}
}
