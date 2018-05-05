package com.guonl.web;

import com.guonl.dao.OrderInfoMapper;
import com.guonl.entity.OrderInfo;
import com.guonl.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by guonl
 * Date 2018/5/2 下午11:18
 * Description:
 */@RestController
@RequestMapping("/order")
public class TestOrderInfoController {

     @Autowired
     private OrderInfoMapper orderInfoMapper;

     @RequestMapping(value = "/init",method = RequestMethod.GET)
     public String initOrderInfo(){
         StringBuilder builder = new StringBuilder();
         builder.append("初始化数据开始……\n");
         long beginTime = System.currentTimeMillis();
         builder.append("开始时间：" + DateTimeUtil.dateToStr(new Date(),DateTimeUtil.STANDARD_FORMAT) + "\n");
         int count = 0;
         for (int i = 0; i < 10000; i++) {
             OrderInfo orderInfo = new OrderInfo();
             orderInfo.setOrderSn(UUID.randomUUID().toString());
             orderInfo.setUserId((int) System.currentTimeMillis() + new Random().nextInt(100));
             orderInfo.setChannelsId((int) System.currentTimeMillis() + new Random().nextInt(100));
             orderInfo.setOrderName("产品" + (i+1));
             orderInfo.setOrderTime(new Date());
             int insert = orderInfoMapper.insert(orderInfo);
             count ++;
         }
         long endTime = System.currentTimeMillis();
         builder.append("一共插入了" + count + "条\n");
         builder.append("结束时间：" + DateTimeUtil.dateToStr(new Date(),DateTimeUtil.STANDARD_FORMAT) + "\n");
         builder.append("总耗时长为：" + (endTime-beginTime) / 1000 + "秒");
         return builder.toString();
     }
}
