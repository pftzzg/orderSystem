package com.wutong.order.srvice;

;import com.wutong.goods.beans.Goods;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by zzg on 2018/6/6.
 */

@FeignClient(value = "order-service")
public interface IOrderService {
    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public Map addCar(@RequestParam("userid") String userid, @RequestParam("goodsid") List<String> goodsid) throws Exception;
}