package com.uclog.threadPool;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.cache.LogCache;
import com.uclog.dto.Logger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * @author yu.wang15
 * @create 2017-08-07 17:05
 **/
public class LogProductThread implements  Runnable{
    public static ThreadLocal<Long> loggerId = new ThreadLocal<Long>();
    @Override
    public void run() {
        Logger logger=new Logger();
        logger.setServerIp("192.168.0.1");
        logger.setHappenTime(new Timestamp(new Date().getTime()));
        Long aLong1 = loggerId.get();
        if(aLong1==null)
            aLong1=0l;
        Long aLong = aLong1+1;
        logger.setLoggerId(aLong);
        loggerId.set(aLong);
        logger.setLoggerLevel(0);
        logger.setClassName("com.uc.class.name"+loggerId);
        int i = new Random().nextInt(1000);
        logger.setLineNum(i+"");
        LogCache.productLog("product_crm",logger);
        System.out.println("生产者生产了一条日志");
    }
}
