package com.uclog.vo;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.remote.RemoteContext;
import com.uclog.utils.GlobalMessage;
import com.uclog.utils.IpUtils;

/**
 * @author yu.wang15
 * @create 2017-08-07 14:39
 **/
public class LogRequestLinkVo {

    private static final long serialVersionUID = 1L;
    private String linkId;
    private long requestLevel;
    private String projectName = GlobalMessage.getProjectName();
    private long times;
    private boolean isSuccess = true;
    private String ip;
    private boolean isClient;
    private String serviceId;
    private String startType;
    private String uid;
    private String eventId;
    private Boolean chainLoggerSwitch;
    private String rpcType;
    private long happenTime;
    private Throwable throwable;
    private String asyncRequestNum;

    public LogRequestLinkVo() {
        this.ip = IpUtils.getLocalIp();
        this.isClient = true;
        this.chainLoggerSwitch = Boolean.valueOf(false);
        this.happenTime = System.currentTimeMillis();
        this.asyncRequestNum = null;
    }

    public String getStartType() {
        return this.startType;
    }

    public void setStartType(String startType) {
        this.startType = startType;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public boolean isClient() {
        return this.isClient;
    }

    public void setClient(boolean isClient) {
        this.isClient = isClient;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public String getIp() {
        return this.ip;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public long getRequestLevel() {
        return this.requestLevel;
    }

    public void setRequestLevel(long requestLevel) {
        this.requestLevel = requestLevel;
    }

    public long getTimes() {
        return this.times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getUid() {
        return this.uid;
    }

    public String getEventId() {
        return this.eventId;
    }

    public Boolean getChainLoggerSwitch() {
        return this.chainLoggerSwitch;
    }



    public String getRpcType() {
        return this.rpcType;
    }

    public void setRpcType(String rpcType) {
        this.rpcType = rpcType;
    }

    public long getHappenTime() {
        return this.happenTime;
    }

    public void setHappenTime(long happenTime) {
        this.happenTime = happenTime;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }




}
