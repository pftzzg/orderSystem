package com.wutong.goods.srvice;

import com.wutong.goods.beans.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zzg on 2018/6/5.
 */
@RestController
public class GoodsService {

    @Value("${server.port}")
    String port;

    //String sku, String img, String id, String goodsName
    @RequestMapping("/queryGoods")
    public List<Goods> queryGoods(Goods goods) {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("sku_1", "https://ss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=2668703443,915611139&fm=202&src=2000&mola=new&crop=v1", "1", "哈弗2 port " + port));
        list.add(new Goods("sku_2", "https://ss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=2668703443,915611139&fm=202&src=2000&mola=new&crop=v1", "1", "哈弗4" + port));
        list.add(new Goods("sku_3", "https://ss2.bdstatic.com/8_V1bjqh_Q23odCf/pacific/1549448767.png", "1", "哈弗5"));
        list.add(new Goods("sku_4", "https://ss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=2668703443,915611139&fm=202&src=2000&mola=new&crop=v1", "1", "哈弗6" + port));
        list.add(new Goods("sku_5", "https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=1206964322,1117863457&fm=85&s=FE80FD09CEE92A8E6AA939860100A0E1", "1", "哈弗2" + port));

        list.add(new Goods("sku_6", "https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=2821856033,2151574840&fm=85&s=7D2305D51A0936CE4A1180D1030000D3", "1", "哈弗9" + port));
        list.add(new Goods("sku_7", "https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=3170905240,3959629053&fm=85&s=6634AF2A5BDF45E9434D2DFA0100A0B2", "1", "哈弗0" + port));
        list.add(new Goods("sku_8", "https://ss2.bdstatic.com/8_V1bjqh_Q23odCf/pacific/1642655487.jpg", "1", "哈弗9" + port));

        list.add(new Goods("sku_8", "https://ss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=2668703443,915611139&fm=202&src=2000&mola=new&crop=v1", "1", "哈弗9" + port));

        list.add(new Goods("sku_10", "https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=3501091895,3470522809&fm=85&s=4F824D81489A36CECB2935810300C0C2", "1", "哈弗0" + port));


        return list;

    }

    @RequestMapping("/queryGoodsByIds")
    public List<Goods> queryGoodsByIds(List<String> ids) {
        List<Goods> list = new ArrayList<>();
        for (String id : ids) {
            list.add(new Goods("sku_1" + id, "https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=2197295606,2656939763&fm=85&s=B280B746CCE3A80967B2AE6903001057", id, "订单服务  " + port));

        }
        return list;
    }


}
