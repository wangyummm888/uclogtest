package com.uclog.listener;/**
 * Created by wangyu on 2017/8/7.
 */

import com.uclog.utils.GlobalMessage;
import com.uclog.utils.IpUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * @author yu.wang15
 * @create 2017-08-07 13:34
 **/
public class ContextLoaderListenerExtend extends ContextLoaderListener {


    public ContextLoaderListenerExtend() {
    }

    public void contextInitialized(ServletContextEvent event) {
        String realpath = event.getServletContext().getRealPath("/");
        GlobalMessage.setPath(realpath);
        String projectName = event.getServletContext().getInitParameter("projectName");
        String projectPath;
        if(StringUtils.isBlank(projectName)) {
            projectPath = event.getServletContext().getContextPath() + "/";
        } else {
            projectPath = "/" + projectName + "/";
        }
         GlobalMessage.setProjectPath(projectPath);
        event.getServletContext().setAttribute("baseContextPath", projectPath);
        String localIp = IpUtils.getLocalIp();
        Assert.notNull(localIp);
        System.setProperty("java.rmi.server.hostname", localIp);
        super.contextInitialized(event);
    }

}
