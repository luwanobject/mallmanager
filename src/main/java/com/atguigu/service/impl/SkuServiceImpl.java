package com.atguigu.service.impl;

import com.atguigu.bean.TMallProduct;
import com.atguigu.bean.TMallSku;
import com.atguigu.bean.TMallSkuAttrValue;
import com.atguigu.mapper.TMallSkuAttrValueMapper;
import com.atguigu.mapper.TMallSkuMapper;
import com.atguigu.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by luwan on 2018/3/27.
 */
@Service
public class SkuServiceImpl implements SkuService{
    @Autowired
    private TMallSkuMapper tMallSkuMapper;
    @Autowired
    private TMallSkuAttrValueMapper tMallSkuAttrValueMapper;

    @Override
    public void saveSku(TMallSku sku, TMallProduct product,List<TMallSkuAttrValue> listattrvalue) {
        //保存sku表，返回主键
        sku.setShpId(product.getId());
        tMallSkuMapper.insertSku(sku);
        //根据sku主键批量保存属性关联表
        HashMap<Object,Object> map=new HashMap<>();

        map.put("skuId",sku.getId());
        map.put("shpId",product.getId());
        map.put("listav",listattrvalue);
        tMallSkuAttrValueMapper.insertSkuAv(map);
    }
}
