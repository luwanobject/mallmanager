package com.atguigu.service;

import com.atguigu.bean.TMallProduct;
import com.atguigu.bean.TMallSku;
import com.atguigu.bean.TMallSkuAttrValue;

import java.util.List;

/**
 * Created by luwan on 2018/3/27.
 */
public interface SkuService {
    void saveSku(TMallSku sku, TMallProduct product, List<TMallSkuAttrValue> listattrvalue);
}
