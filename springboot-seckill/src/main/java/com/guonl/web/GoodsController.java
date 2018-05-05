package com.guonl.web;

import com.guonl.entity.Goods;
import com.guonl.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by guonl
 * Date 2018/5/5 下午12:03
 * Description:
 */
@Api(description = "商品列表")
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "获取商品列表")
    @ResponseBody //一旦是用了这个注解，thymeleaf就找不到页面，直接返回字符串
    @RequestMapping(value = "/getList",method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List getGoodsList(){
        List<Goods> list = goodsService.getGoodsList();
        return list;
    }


}
