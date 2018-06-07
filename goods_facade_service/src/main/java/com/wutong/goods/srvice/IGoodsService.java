package com.wutong.goods.srvice;

import com.wutong.goods.beans.Goods;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zzg on 2018/6/6.
 */
;
@FeignClient(value = "goods-bak-service")
public interface IGoodsService {
    @RequestMapping(value = "/queryGoods",method = RequestMethod.POST)
    public List<Goods> queryGoods(@RequestBody Goods goods);
    @RequestMapping(value = "/queryGoodsByIds",method = RequestMethod.POST)
    public List<Goods> queryGoodsByIds(List<String> ids);

}
