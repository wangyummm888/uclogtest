package com.uclog.logger;/**
 * Created by wangyu on 2017/8/7.
 */

import com.alibaba.fastjson.JSON;
import com.uclog.dto.SqlLogger;
import com.uclog.threadPool.CommonThreadPool;
import com.uclog.threadPool.ThreadPoolParameterVO;
import com.uclog.utils.GlobalMessage;
import com.uclog.utils.IpUtils;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * @author yu.wang15
 * @create 2017-08-07 11:11
 **/
public class DatabaseAppender extends AppenderSkeleton {
    public static final String LOCAL_IP = IpUtils.getLocalIp(); //获取本机IP
    public static final ExecutorService POOL = CommonThreadPool.getThreadPool(new ThreadPoolParameterVO());  //获取线程池来进行处理
    private static final int DEFAULT_BUFFER_SIZE = 20;
    private static ThreadLocal<Map<String, List<SqlLogger>>> bufferListLocal = new ThreadLocal();
    private int bufferSize = 20;



    @Override
    protected void append(LoggingEvent loggingEvent) {
        Object map = (Map)bufferListLocal.get();
        if(map == null) {
            map = new HashMap();
            bufferListLocal.set((Map<String, List<SqlLogger>>) map);
        }
        /**
         *
         */
        Object message = loggingEvent.getMessage();
        String ndc = loggingEvent.getNDC();
        String threadName = loggingEvent.getThreadName();
        loggingEvent.getMDCCopy();
        LocationInfo locationInformation = loggingEvent.getLocationInformation();
        String renderedMessage = loggingEvent.getRenderedMessage();
        String[] throwableStrRep = loggingEvent.getThrowableStrRep();
        SqlLogger logger1 = SqlLoggerFactory.getInstance(loggingEvent);
        String topicId1 = logger1.getTopicId();
        Object bufferList = (List)((Map)map).get(topicId1);
        if(bufferList == null) {
            bufferList = new ArrayList(this.bufferSize);
            ((Map)map).put(topicId1, bufferList);
        }
        ((List)bufferList).add(logger1);
        if(((List)bufferList).size() >= this.bufferSize) {
            this.flushBuffer(topicId1, (List)bufferList);
        }
    }


    /**
     * 刷新当前
     * @param topicId1
     * @param bufferList
     */
    private void flushBuffer(String topicId1, List bufferList) {
        System.out.println("topicId"+topicId1+",:bufferList num:"+bufferList);
        for ( Object  o: bufferList) {
            String string = JSON.toJSONString((SqlLogger) o);
            System.out.println(string);
        }
    }


    public static List<SqlLogger> getLoggerAndClean(List<SqlLogger> list) {
        if(list == null) {
            return null;
        } else {
            ArrayList thisList = new ArrayList();
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                SqlLogger logger = (SqlLogger)i$.next();
                logger.setServerIp(LOCAL_IP);
                logger.setProjectName(GlobalMessage.getProjectPath());
                thisList.add(logger);
            }

            list.clear();
            return thisList;
        }
    }


    @Override
    public void close() {

    }





    @Override
    public boolean requiresLayout() {
        return false;
    }
}
