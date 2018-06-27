package com.guonl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import wang.moshu.smvc.framework.DispatchServlet;

/**
 * Created by guonl
 * Date 2018/6/25 下午3:54
 * Description: 启动类
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:spring-*.xml"})
@ComponentScan(basePackages = {"com.guonl", "wang.moshu"})
//@Import(value = {SpringBeanUtils.class})
public class ApplicationRedisMq {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRedisMq.class, args);
    }

    // springboot 自定义Servlet,Filter,listener
    // https://blog.csdn.net/cb2474600377/article/details/54628770


    /*@Bean
    public ServletRegistrationBean restServlet(){
        //注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext
                = new AnnotationConfigWebApplicationContext();
        //base package
        applicationContext.scan("wang.moshu");
        //通过构造函数指定dispatcherServlet的上下文
        DispatcherServlet rest_dispatcherServlet
                = new DispatcherServlet(applicationContext);

        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean
                = new ServletRegistrationBean(rest_dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        //指定urlmapping
        registrationBean.addUrlMappings("/test/*");
        //指定name，如果不指定默认为dispatcherServlet
        registrationBean.setName("test");
        return registrationBean;
    }*/



}
