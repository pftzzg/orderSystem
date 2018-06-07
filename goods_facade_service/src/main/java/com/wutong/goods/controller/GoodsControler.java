package com.wutong.goods.controller;

import com.google.common.collect.Lists;
import com.wutong.goods.beans.Goods;
import com.wutong.goods.srvice.IGoodsService;
import com.wutong.order.srvice.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zzg on 2018/6/5.
 */
@RestController("/goods")
public class GoodsControler {
    @Autowired
    IGoodsService goodsService;


    @Autowired
    IOrderService orderService;

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public ModelAndView getQueryList(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("queryList");
        Goods goods = new Goods();
        List<Goods> list = goodsService.queryGoods(goods);

        modelAndView.addObject("list", list);
        modelAndView.setViewName("queryList");
        return modelAndView;
    }


    @RequestMapping(value = "/buy")
    @ResponseBody
    public Map buy(@RequestParam String userid, @RequestParam String id, ModelAndView modelAndView) throws Exception {
        List gs = new ArrayList();
        gs.add(id);
        Map data = orderService.addCar(userid, gs);
        return data;
    }

}
