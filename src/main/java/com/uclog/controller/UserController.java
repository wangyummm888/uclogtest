package com.uclog.controller;/**
 * Created by wangyu on 2017/8/10.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户
 *
 * @author yu.wang15
 * @create 2017-08-10 18:56
 **/
@Controller
@RequestMapping("/user")
public class UserController {


    private  static final String TO_EDIT_PASSWORD="page/toEditPassword";


    @RequestMapping("toEditPassword")
    public String toEditPassword(){
        return TO_EDIT_PASSWORD;
    }






}
