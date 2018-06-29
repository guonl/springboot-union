package com.guonl.controller;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by guonl
 * Date 2018/6/28 下午3:21
 * Description:
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    public CuratorFramework zkClient;

    //参考地址：https://blog.csdn.net/smartbetter/article/details/53083816

    @ResponseBody
    @RequestMapping(value = "/zk/{name}", method = RequestMethod.GET)
    public String test(@PathVariable String name) throws Exception {

        //判断是否存在，Stat就是对znode所有属性的一个映射，stat=null表示节点不存在
        Stat stat = zkClient.checkExists().forPath("/curator/2");

        //获取子节点列表
        List<String> list = zkClient.getChildren().forPath("/");

        //增
        if("add".equals(name)){
            zkClient.create().creatingParentsIfNeeded()//若创建节点的父节点不存在则先创建父节点再创建子节点
                    .forPath("/curator/2", "1".getBytes());
        }

        //改
        if("modify".equals(name)){
            zkClient.setData().forPath("/curator/2", "0".getBytes());
        }

        //查
        if("query".equals(name)){
            //String re = new String(client.getData().forPath("/curator/2"));//只获取数据内容
            //Stat就是对znode所有属性的一个映射，stat=null表示节点不存在
            String re = new String(zkClient.getData()
                    .storingStatIn(new Stat())//在获取节点内容的同时把状态信息存入Stat对象
                    .forPath("/curator/2"));
        }

        //删
        if("delete".equals(name)){
            zkClient.delete().guaranteed()//保障机制，若未删除成功，只要会话有效会在后台一直尝试删除
                    .deletingChildrenIfNeeded()//若当前节点包含子节点
                    .withVersion(-1)//指定版本号
                    .forPath("/curator");
        }

        return name;
    }


}
