package com.guonl.anno.core;

import com.guonl.spi.CoordinatorStorage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: SecurityPolicyInterceptor2
 * @Description: 统一拦截
 * @author lenovo
 * @date 2018年6月20日
 * 
 */
public class SecurityPolicyInterceptor2 extends HandlerInterceptorAdapter {

	private CoordinatorStorage coordinatorStorage;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截成功……");
		return true;
	}



}
