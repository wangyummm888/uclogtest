package com.uclog.listener;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.threadPool.LogCustomerThread;
import com.uclog.threadPool.LogProductThread;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yu.wang15
 * @create 2017-08-07 16:51
 **/
public class LogTestListenerExtend extends ContextLoaderListener {


    public LogTestListenerExtend() {
    }

    public void contextInitialized(ServletContextEvent event) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(2);
        LogProductThread newOne=new LogProductThread();
        LogCustomerThread customerThread=new LogCustomerThread();
        scheduledExecutorService.scheduleAtFixedRate(newOne,0,1, TimeUnit.SECONDS);
        scheduledExecutorService2.scheduleAtFixedRate(customerThread,0,2,TimeUnit.SECONDS);
    }

}
