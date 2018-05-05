package com.guonl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by guonl
 * Date 2018/5/5 上午10:22
 * Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:spring/application-*.xml"})
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class,args);
    }


}
