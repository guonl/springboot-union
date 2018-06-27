/**
 * @author Big Martin
 *
 */
package com.guonl.intercept.annotation;

import com.guonl.intercept.core.RequestInterceptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by guonl
 * Date 2018/6/26 下午5:02
 * Description: 拦截列表，作用于类或者方法
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Intercept
{
	Class<? extends RequestInterceptor>[] value();
}
