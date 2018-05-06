package com.guonl.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by guonl
 * Date 2018/5/5 上午10:26
 * Description:
 */
@Api(description = "测试")
@Controller
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("name","guonl");
        return "index";
    }

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public String goods(Model model){
        return "list";
    }

}
