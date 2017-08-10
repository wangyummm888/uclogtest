package com.uclog.controller;/**
 * Created by wangyu on 2017/8/10.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *
 * @author yu.wang15
 * @create 2017-08-10 15:15
 **/
@Controller
@RequestMapping("/index")
public class IndexController {

   private static final String INDEX="index";

    @RequestMapping("toIndex")
    public String toIndex(){
        return INDEX;
    }



}
