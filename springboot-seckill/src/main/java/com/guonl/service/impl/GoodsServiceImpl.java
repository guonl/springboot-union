package com.guonl.service.impl;

import com.guonl.dao.GoodsMapper;
import com.guonl.entity.Goods;
import com.guonl.entity.GoodsExample;
import com.guonl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guonl
 * Date 2018/5/5 下午12:05
 * Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsList() {
        GoodsExample example = new GoodsExample();
        List<Goods> list = goodsMapper.selectByExample(example);
        return list;
    }
}
