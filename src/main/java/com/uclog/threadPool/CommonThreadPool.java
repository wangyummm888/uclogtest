package com.uclog.threadPool;/**
 * Created by wangyu on 2017/8/7.
 */

import java.util.concurrent.*;

/**
 * 线程池对象
 *
 * @author yu.wang15
 * @create 2017-08-07 11:19
 **/
public class CommonThreadPool {

    /**
     * 根据参数获取线程池对象
     * @param vo
     * @return
     */
    public static ThreadPoolExecutor getThreadPool(ThreadPoolParameterVO vo) {
        int corePoolSize = vo.getCorePoolSize();
        int maximumPoolSize = vo.getMaximumPoolSize();
        long keepAliveTime = vo.getKeepAliveTime();
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }
}
