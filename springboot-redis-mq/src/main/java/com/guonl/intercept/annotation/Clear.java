/**
 * @author Big Martin
 *
 */

package com.guonl.intercept.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.guonl.intercept.core.RequestInterceptor;

/**
 * Created by guonl
 * Date 2018/6/26 下午5:01
 * Description: 清除的拦截器列表，仅用于方法上清除类上的某几个拦截器
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Clear
{
	Class<? extends RequestInterceptor>[] value() default {};
}