package com.neo.designmode.factory;

/**
 * create by xiaocai on 2020/9/18 17:56
 *
 **/
public class Test {
    public static void main(String[] args) {
        LowerFactory lowerFactory = new LowerFactory();
        lowerFactory.creatMask();
        lowerFactory.createProtectiveSuit();
        System.out.println("------------------------");
        UpperFactory upperFactory = new UpperFactory();
        upperFactory.createProtectiveSuit();
        upperFactory.creatMask();
    }
}
