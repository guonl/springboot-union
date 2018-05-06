package com.guonl.web;

import com.guonl.service.SecKillService;
import com.guonl.vo.Exposer;
import com.guonl.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by guonl
 * Date 2018/5/6 上午11:09
 * Description: 秒杀接口
 */
@Api(description = "秒杀接口")
@Controller
@RequestMapping("/")
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    /**
     * 查询系统时间
     * @return
     */
    @ApiOperation(value = "获取系统时间")
    @RequestMapping(value = "time/now",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo<Long> time() {
        long now = System.currentTimeMillis();
        return new ResultVo(true,now);
    }


    /**
     * 秒杀接口
     * @param mobile
     * @param goodsRandomName
     * @return
     */
//    @Intercept(value = {UserInterceptor.class})
    @RequestMapping(value = "miaosha", method = RequestMethod.GET)
    public String miaosha(String mobile, String goodsRandomName) {

        secKillService.miaosha(mobile, goodsRandomName);

        // 为什么要返回mobile，为了方便jmeter测试
        return mobile;
    }





}
