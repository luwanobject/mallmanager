package com.atguigu.controller;


import com.atguigu.bean.MallAttrVO;
import com.atguigu.bean.ModelMallAttr;
import com.atguigu.service.AttrServiceInf;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwan on 2018/3/25.
 */
@Controller
public class AttrController {

    private static final Logger logger = Logger.getLogger(SpuController.class);
    @Autowired
    private AttrServiceInf asttrServiceInf;



    @RequestMapping("/get_attr_list_json")
    @ResponseBody
    public List<MallAttrVO> get_attr_list_json(int flbh2,ModelMap map) {
//        logger.info(flhb2);
        List<MallAttrVO> list_attr = new ArrayList<MallAttrVO>();
        list_attr=asttrServiceInf.asttrServiceInf(flbh2);
        map.put("flhb2", flbh2);

        map.put("list_attr", list_attr);
//        logger.info(list_attr);
        return list_attr;
    }

    @RequestMapping("/get_attr_list")
    public String get_attr_list(int flbh2,ModelMap map) {
//        logger.info(flhb2);
        List<MallAttrVO> list_attr = new ArrayList<MallAttrVO>();
        list_attr=asttrServiceInf.asttrServiceInf(flbh2);
        map.put("flhb2", flbh2);

        map.put("list_attr", list_attr);
//        logger.info(list_attr);
        return "attrListInner";
    }


    @RequestMapping("/goto_attr_add")
    public String goto_attr_add(String flbh2, ModelMap map) {
        map.addAttribute("flbh2",flbh2);
        logger.info("print towid"+flbh2);
        return "attrAdd";
    }

    @RequestMapping("/attr_add")
    public ModelAndView attr_add(int flbh2, ModelMallAttr list_attr ) {

        ModelAndView mv=new ModelAndView("redirect:/goto_attr_add.do");

        asttrServiceInf.saveAttr(flbh2,list_attr.getList_attr());
        mv.addObject("flbh2",flbh2);


        //2、保存地址


        return mv;
    }
}
