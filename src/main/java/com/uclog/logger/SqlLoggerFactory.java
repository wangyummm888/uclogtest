package com.uclog.logger;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.dto.SqlLogger;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author yu.wang15
 * @create 2017-08-07 13:13
 **/
public class SqlLoggerFactory {


    private SqlLoggerFactory() {
    }


    public static SqlLogger getInstance(LoggingEvent event) {
        Level level = event.getLevel();
        SqlLogger logger = new SqlLogger();
        LocationInfo localInfo = event.getLocationInformation();
        logger.setClassName(localInfo.getClassName());
        logger.setMethodName(localInfo.getMethodName());
        logger.setLineNum(localInfo.getLineNumber());
        logger.setLoggerLevel(level.toInt());
        long timeStamp = event.timeStamp;
        logger.setHappenTime(new Timestamp(timeStamp));
        logger.setServerIp(DatabaseAppender.LOCAL_IP);
        logger.setWriteTime(new Timestamp(new Date().getTime()));
        ThrowableInformation throwableInfoObject = event.getThrowableInformation();
        if(throwableInfoObject != null) {
            String throwableInfoArray = throwableInfoObject.getThrowable().getClass().getName();
            logger.setThrowableName(throwableInfoArray);
            Throwable message = throwableInfoObject.getThrowable();
        }
        return  logger;

    }


}
