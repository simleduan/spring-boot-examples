package com.neo.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/11
 * @Version V1.0
 **/
public class LocalUtils {
    public static  String getHostName(){
        String hostName ="";
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
            if(null ==ip){
                ip = InetAddress.getLocalHost();
            }
            hostName += ip.getHostName()+":"+ip.getHostAddress();
        }catch (Exception ex){
            // do nothing
        }
        return hostName;
    }
}
