package com.guonl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by guonl
 * Date 2018/5/3 上午11:23
 * Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource({ "classpath:spring/application-*.xml" })
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
