package com.wutong.goods.srvice.impl;

import com.google.common.collect.Lists;
import com.wutong.goods.beans.Goods;
import com.wutong.goods.srvice.IGoodsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzg on 2018/6/6.
 */
@Component
public class GoodsServiceFallback implements IGoodsService {
    @Override
    public List<Goods> queryGoods(@RequestBody Goods goods) {
        Goods gs = new Goods();
        gs.setGoodsName("error");
        List list = new ArrayList();
        list.add(gs);
        return list;
    }

    @Override
    public List<Goods> queryGoodsByIds(List<String> ids) {
        return null;
    }
}
