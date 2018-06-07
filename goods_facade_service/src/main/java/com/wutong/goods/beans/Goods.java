package com.wutong.goods.beans;

/**
 * Created by zzg on 2018/6/5.
 */
public class Goods {
    public Goods() {
    }

    public Goods(String sku, String img, String id, String goodsName) {
        super();
        this.sku = sku;
        this.img = img;
        this.id = id;
        this.goodsName = goodsName;


    }

    private String sku;
    private String img;
    private String id;
    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
