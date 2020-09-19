package com.neo.designmode.factory;

import javax.xml.bind.SchemaOutputResolver;

/**
 * create by xiaocai on 2020/9/18 17:46
 **/
public class UpperMask implements IMask {
    @Override
    public void showMask() {
        System.out.println("高端口罩");
    }
}
