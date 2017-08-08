package com.uclog.cache;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.dto.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author yu.wang15
 * @create 2017-08-07 15:54
 **/
public class LogCache {
    public static final int QUEUE_SIZE=1000;
    public static final ConcurrentHashMap<String,Queue<Logger>> logQueueCache=new ConcurrentHashMap<String,Queue<Logger>>();
    public static final ConcurrentHashMap<String,List<Logger>>  logListCache=new ConcurrentHashMap<String, List<Logger>>();

    public static boolean  productLog(String topic,Logger log){
        boolean add =false;
        if(logQueueCache.get(topic)==null){
                Queue<Logger> queue=new ArrayBlockingQueue<Logger>(QUEUE_SIZE);
                queue.add(log);
                logQueueCache.put(topic,queue);
                add=true;
            }else {
                add = logQueueCache.get(topic).add(log);
            }
        return add;
    }

    public static void consumerLog(String topic){
        Queue<Logger> queue = logQueueCache.get(topic);
        List<Logger> list = logListCache.get(topic);
        if(queue==null)return;
        Iterator<Logger> iterator = queue.iterator();
        while(iterator.hasNext()){
            Logger next = iterator.next();
            if(list!=null&&logListCache.size()>QUEUE_SIZE*5){
                 list.remove(0);
                 list.add(next);
            }else if (list!=null){
                list.add(next);
            }else{
                List<Logger> list2 =new ArrayList<Logger>();
                list2.add(next);
                logListCache.put(topic,list2);
            }
        }
    }


    public static List<Logger> getLogCache(String topic,Long logId,int size){
            List<Logger> list = logListCache.get(topic);
            if(list==null) return null;
            List<Logger> newList=new ArrayList<Logger>(list);
            List<Logger> resultList=new ArrayList<Logger>();
            int num=0;
            if(logId==null)logId=0L;
            for (Logger logger : newList) {
                if(logger.getLoggerId()>logId){
                    resultList.add(logger);
                    num++;
                }
                if(num>=size){
                    return resultList;
                }
            }
            return resultList;
    }

}
