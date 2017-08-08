package com.uclog.threadPool;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.cache.LogCache;

/** 日志消费线程
 * @author yu.wang15
 * @create 2017-08-07 17:28
 **/
public class LogCustomerThread implements  Runnable {

    @Override
    public void run() {
        LogCache.consumerLog("product_crm");
        System.out.println("消费者消费了一条日志");
    }
}
