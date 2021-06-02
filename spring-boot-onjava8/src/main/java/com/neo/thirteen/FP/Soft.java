package com.neo.thirteen.FP;

/**
 * create by xiaocai on 2021/5/10 10:55
 **/
public class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}
