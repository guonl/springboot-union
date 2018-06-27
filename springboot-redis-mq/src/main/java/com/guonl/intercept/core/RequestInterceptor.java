package com.guonl.intercept.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by guonl
 * Date 2018/6/26 下午3:43
 * Description: 接口拦截器
 */
public interface RequestInterceptor {

    /**
     * 拦截器描述
     *
     * @return
     */
    String description();

    /**
     * 前置拦截方法
     *
     * @param request  http request
     * @param response http response
     * @return true:请求继续，false:请求终止
     * @throws Exception
     */
    boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 后置拦截方法，如果有异常抛出，则该拦截器不走
     *
     * @param request
     * @param response
     * @param returnObj
     * @throws Exception
     */
    void postHandle(HttpServletRequest request, HttpServletResponse response, Object returnObj) throws Exception;

    /**
     * 操作完成拦截方法，和postHandle的区别在于：不管有没有异常抛出，该拦截方法必走
     *
     * @param request
     * @param response
     * @throws Exception
     */
    void commitHandle(HttpServletRequest request, HttpServletResponse response);
}
