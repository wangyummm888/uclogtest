package com.uclog.controller;/**
 * Created by wangyu on 2017/8/7.
 */

import com.alibaba.fastjson.JSON;
import com.uclog.cache.LogCache;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志测试controller
 *
 * @author yu.wang15
 * @create 2017-08-07 10:34
 **/
@Controller
public class LogController {

    private Logger logger=Logger.getLogger(this.getClass());

    @RequestMapping("index")
    public String toIndex(){
        logger.info("登陆开始了啊");
        return "index";
    }



    @RequestMapping("toLog")
    public String toLog(){
        return "log";
    }


    @RequestMapping("getLog")
    @ResponseBody
    public String getLog(String topic, Long logId, int size){
        List<com.uclog.dto.Logger> logCache = LogCache.getLogCache(topic, logId, size);
        if(logCache==null){
            logCache=new ArrayList<com.uclog.dto.Logger>();
        }
        return JSON.toJSONString(logCache);
    }


}
