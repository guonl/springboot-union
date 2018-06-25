package com.guonl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by guonl
 * Date 2018/6/25 下午3:54
 * Description: 启动类
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:spring-mt.xml"})
@ComponentScan({"com.guonl","wang.moshu"})
public class ApplicationRedisMq {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRedisMq.class,args);
    }
}
