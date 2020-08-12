package com.neo.other;

import com.neo.utils.LocalUtils;

public class Test {
    public static void main(String[] args) {
        String hostName = LocalUtils.getHostName();
        System.out.println(hostName);
    }
}
