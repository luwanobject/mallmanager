package com.atguigu.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luwan on 2018/3/23.
 */
@Controller
public class IndexController {

    private static final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping("/goto_sku")
    public String goto_sku() {
        return "sku";
    }

    @RequestMapping("/goto_attr")
    public String goto_attr() {
        return "attr";
    }

    @RequestMapping("/goto_spu")
    public String goto_spu() {
        return "spu";
    }

    @RequestMapping("/index")
    public String index() {
        return "main";
    }

}
