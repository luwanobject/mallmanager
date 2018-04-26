package com.atguigu.controller;

import com.atguigu.bean.MallAttrVO;
import com.atguigu.bean.ModelMallAttr;
import com.atguigu.bean.TMallProduct;
import com.atguigu.bean.TMallSku;
import com.atguigu.service.AttrServiceInf;
import com.atguigu.service.SkuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by luwan on 2018/3/26.
 */
@Controller
public class SkuController {

    private static final Logger logger = Logger.getLogger(SkuController.class);

    @Autowired
    private AttrServiceInf asttrServiceInf;

    @Autowired
    private SkuService skuService;


    @RequestMapping("/goto_sku_add")
    public String goto_sku(@RequestParam("flbh1") Integer flbh1, @RequestParam("flbh2") Integer flbh2, ModelMap map) {
        //加载属性和属性值列表
        List<MallAttrVO> mallAttrVOS = asttrServiceInf.asttrServiceInf(flbh2);
        map.addAttribute("flbh1",flbh1);
        map.put("flbh2",flbh2);
        map.put("mallAttrVOS",mallAttrVOS);
        logger.info(mallAttrVOS);
        return "skuadd";
    }

    @RequestMapping("/inserSku")
    public ModelAndView inserSku(TMallSku sku,TMallProduct product, ModelMallAttr listattrvalue, @RequestParam("flbh1") Integer flbh1, @RequestParam("flbh2") Integer flbh2){

        skuService.saveSku(sku,product,listattrvalue.getListattrvalue());
        ModelAndView mv=new ModelAndView("redirect:/goto_sku_add.do");
        mv.addObject("flbh1",flbh1);
        mv.addObject("flbh2",flbh2);
        logger.info("com in");
        return  mv;

    }
}
