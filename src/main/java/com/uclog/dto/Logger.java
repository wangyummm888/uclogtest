package com.uclog.dto;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.constant.SwitchConstant;

import java.sql.Timestamp;

/**
 * 日志对象
 *
 * @author yu.wang15
 * @create 2017-08-07 16:39
 **/
public class Logger {
    private Long loggerId;
    private String linkId;
    private String serverIp;
    private String projectName;
    private String className;
    private String methodName;
    private String lineNum;
    private String loggerMessage;
    private Integer loggerLevel;
    private Integer loggerType;
    private transient Timestamp happenTime;
    private transient Timestamp writeTime;
    private String throwableName;
    private String topicId = "";

    public String getTopicId() {
        return this.topicId;
    }

    public void setTopicId(String topicId) {
        if(topicId == null || SwitchConstant.LOG_SPLIT_SWITCH) {
            this.topicId = topicId;
        }
    }

    public Long getLoggerId() {
        return loggerId;
    }

    public void setLoggerId(Long loggerId) {
        this.loggerId = loggerId;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public String getLoggerMessage() {
        return loggerMessage;
    }

    public void setLoggerMessage(String loggerMessage) {
        this.loggerMessage = loggerMessage;
    }

    public Integer getLoggerLevel() {
        return loggerLevel;
    }

    public void setLoggerLevel(Integer loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    public Integer getLoggerType() {
        return loggerType;
    }

    public void setLoggerType(Integer loggerType) {
        this.loggerType = loggerType;
    }

    public Timestamp getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Timestamp happenTime) {
        this.happenTime = happenTime;
    }

    public Timestamp getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Timestamp writeTime) {
        this.writeTime = writeTime;
    }
    public String getThrowableName() {
        return this.throwableName;
    }

    public void setThrowableName(String throwableName) {
        this.throwableName = throwableName;
    }
}
