package com.uclog.controller;/**
 * Created by wangyu on 2017/8/10.
 */

import com.alibaba.fastjson.JSON;
import com.uclog.model.Navs;
import com.uclog.service.NavsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 左侧导航
 *
 * @author yu.wang15
 * @create 2017-08-10 16:00
 **/
@Controller
@RequestMapping("/navs")
public class NavsController
{
    private Logger logger=Logger.getLogger(this.getClass());
    @Resource
    NavsService navsService;


    @RequestMapping(value = "/getNavs",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getNavs(){
        List<Navs> navs = null;
        try{
            navs= navsService.getNavs();
        }catch (Exception e){
            logger.error("查询导航页出错",e);
        }
        return JSON.toJSONString(navs);
    }




}
