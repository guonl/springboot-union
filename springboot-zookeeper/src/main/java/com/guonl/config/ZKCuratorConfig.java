package com.guonl.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by guonl
 * Date 2018/6/28 下午2:07
 * Description:
 */
@Configuration
public class ZKCuratorConfig {

    @Value("${zookeeper_server}")
    private String zookeeper_server;

    private CuratorFramework client = null;

    @Bean(name = "zkClient")
    public CuratorFramework zkCuratorClient(){
        // 创建ZK客户端，如果存在则不需要再次创建
        if(client != null){
            return client;
        }
        client = CuratorFrameworkFactory.builder().connectString(zookeeper_server)
                .sessionTimeoutMs(1000)//连接超时时间
                .connectionTimeoutMs(1000)//会话超时时间
                //刚开始重试间隔为1秒，之后重试间隔逐渐增加，最多重试不超过三次
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("admin")
                .build();
        // 启动客户端
        client.start();
        // 使用命名空间
        client = client.usingNamespace("admin");
        // 启动完成之后监听/admin路径

        return client;
    }


}
