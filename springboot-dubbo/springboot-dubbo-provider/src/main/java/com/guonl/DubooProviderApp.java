package com.guonl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by guonl
 * Date 2018/6/27 下午2:06
 * Description:
 */
@SpringBootApplication(exclude = {RedisAutoConfiguration.class, SessionAutoConfiguration.class, DataSourceAutoConfiguration.class})
@ImportResource({ "classpath:spring/application-*.xml" })
public class DubooProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(DubooProviderApp.class, args);
    }
}
