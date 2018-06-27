package com.guonl.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController 
 * @Description: 一个简单的REST
 * @author guonl
 * @date 2017年7月16日 下午10:11:46 
 * @version V1.0   
 *
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}