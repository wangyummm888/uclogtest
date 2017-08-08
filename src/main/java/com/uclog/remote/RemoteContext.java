package com.uclog.remote;/**
 * Created by wangyu on 2017/8/7.
 */

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yu.wang15
 * @create 2017-08-07 14:42
 **/
public class RemoteContext {

    public static final String WAIT_TIMEOUT = "waitTimeOut"; //等待超时
   //本地线程 初始化
    private static final ThreadLocal<RemoteContext> LOCAL = new ThreadLocal() {
        protected RemoteContext initialValue() {
            return new RemoteContext();
        }
    };

    public static final ThreadLocal<String> SERVICE_CONTEXT = new ThreadLocal();


    private String serviceId; //服务Id
    private String className; //类名
    private String methodName; //方法名
    private Class<?>[] parameterTypes; //参数类型
    private Object[] arguments; //参数列表
    private InetSocketAddress localAddress;//本机地址
    private InetSocketAddress remoteAddress; //远程地址
    private Object result; //返回值
    private String clientProjectName; //客户端调用名称
    private final Map<String, String> attachments = new HashMap();
    private final Map<String, Object> values = new HashMap();

    protected RemoteContext() {
    }
    public static RemoteContext getContext() {
        return (RemoteContext)LOCAL.get();
    }

    public static void removeContext() {
        SERVICE_CONTEXT.remove();
        LOCAL.remove();
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return this.parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }






}
