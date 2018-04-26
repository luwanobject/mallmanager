package com.atguigu.controller;

import com.atguigu.bean.TMallProduct;
import com.atguigu.service.SpuService;
import com.atguigu.utils.MyFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by luwan on 2018/3/23.
 */

@Controller
public class SpuController {
    private static final Logger logger = Logger.getLogger(SpuController.class);

    @Value("${windows_path}")
    private String WINDOWS_PATH;

    @Autowired
    private SpuService supervice;

   /* @RequestMapping("/get_spu_list")
    public void get_spu_list(@RequestParam(value = "ppid", required = false) Integer ppid , @RequestParam(value = "flbh2", required = false) Integer flbh2, HttpServletResponse response) throws IOException {
        logger.info("*************"+ppid);
        logger.info("*************"+flbh2);
        List<TMallProduct> list_spu = supervice.get_spu_list(ppid, flbh2);
        logger.info(list_spu);
        Gson g=new Gson();
        String s = g.toJson(list_spu);
        logger.info(s);
        response.getWriter().print(s);
    }
*/
    @RequestMapping("/get_spu_list")
    @ResponseBody
    public List<TMallProduct> get_spu_list(@RequestParam(value = "ppid", required = false) Integer ppid , @RequestParam(value = "flbh2", required = false) Integer flbh2, HttpServletResponse response) {
        logger.info("*************"+ppid);
        logger.info("*************"+flbh2);
        List<TMallProduct> list_spu =supervice.get_spu_list(ppid, flbh2);

        return list_spu;
    }

    /**
     *
     * @param map
     * @param spu
     * @return
     */
    @RequestMapping("/goto_spu_add")
    public String goto_spu_add(ModelMap map, TMallProduct spu) {

        map.put("spu", spu);
        return "spuAdd";
    }

    @RequestMapping("/spu_add")
    public ModelAndView spu_add(String index, TMallProduct spu, @RequestParam("files") MultipartFile[] files) throws Exception {



        //1、上传图片
        List<String> list_image = MyFileUpload.upload_image(files,WINDOWS_PATH);


        //插入商品信息
        supervice.insertProduct(list_image,spu,index);
        ModelAndView mv=new ModelAndView("redirect:/goto_spu_add.do");

        mv.addObject("flbh1",spu.getFlbh1());
        mv.addObject("flbh2",spu.getFlbh2());
        mv.addObject("ppId",spu.getPpId());
        //2、保存地址


        return mv;
    }

}
