package com.uclog.threadPool;/**
 * Created by wangyu on 2017/8/7.
 */

/**
 * 线程池参数
 *
 * @author yu.wang15
 * @create 2017-08-07 11:22
 **/
public class ThreadPoolParameterVO {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOLSIZE = 200;
    private static final int INITIAL_CAPACITY = 1000000;
    private static final int KEEP_ALIVE_TIME = 120;
    private int corePoolSize = 5;
    private int maximumPoolSize = 200;
    private int initialCapacity = 1000000;
    private long keepAliveTime = 120L;
    private String threadName = "base-framework-threadPool-";
    private boolean isDiscard = true;

    public boolean isDiscard() {
        return this.isDiscard;
    }

    public void setDiscard(boolean isDiscard) {
        this.isDiscard = isDiscard;
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public int getInitialCapacity() {
        return this.initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public long getKeepAliveTime() {
        return this.keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }


}
