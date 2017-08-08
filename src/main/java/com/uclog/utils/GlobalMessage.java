package com.uclog.utils;/**
 * Created by wangyu on 2017/8/7.
 */

import java.io.File;

/**
 * @author yu.wang15
 * @create 2017-08-07 13:28
 **/
public class GlobalMessage {
    public static final String PATH_ENV = "logfile.path";
    private static String contextPath;
    private static String projectPath;
    private static String projectName;
    private static int httpPort;
    private static String defaultLogfilePath;

    private GlobalMessage() {
    }

    public static String getProjectName() {
        return projectName;
    }

    public static String getPath() {
        return contextPath;
    }

    public static void setPath(String path) {
        contextPath = path;
    }

    public static String getProjectPath() {
        return projectPath;
    }

    public static void setProjectPath(String projectPath) {
        projectPath = projectPath;
        projectName = projectPath.substring(1, projectPath.length() - 1);
        System.setProperty("framework.web.projectName", projectName);
    }

    public static int getHttpPort() {
        return httpPort;
    }

    static void setHttpPort(int httpPort) {
        httpPort = httpPort;
    }

    public static String getProjectNameNew() {
        return getProjectName() == null?System.getProperty("sz.framework.projectName"):getProjectName();
    }

    public static String getLogfilePath() {
        String filePath = System.getProperty("logfile.path");
        return filePath == null?defaultLogfilePath:(filePath.endsWith(File.separator)?filePath:filePath + File.separator);
    }

    static {
        defaultLogfilePath = System.getProperty("catalina.home") + File.separator + "logs" + File.separator;
    }


}
