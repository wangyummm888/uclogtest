package com.uclog.utils;/**
 * Created by wangyu on 2017/8/7.
 */

import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author yu.wang15
 * @create 2017-08-07 11:13
 **/
public class IpUtils {
    public static String getLocalIp(){
        Enumeration netInterfaces= null;
        String address=null;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while(netInterfaces.hasMoreElements())
            {
                NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                Enumeration ips = ni.getInetAddresses();

                while(ips.hasMoreElements()) {
                    InetAddress ipObj = (InetAddress)ips.nextElement();
                    if(ipObj.isSiteLocalAddress()) {
                        address = ipObj.getHostAddress();
                        return address;
                    }
                }
            }
        } catch (SocketException e) {
           System.out.print("获取本机IP出错");
            e.printStackTrace();
        }
        return address;
    }


}
