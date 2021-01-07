package com.neo.designmode.chain;

/**
 * create by xiaocai on 2021/1/4 11:34
 **/
public class HandleRuleA extends Handler {
    public HandleRuleA(int level) {
        super(level);
    }

    @Override
    public void echo(Request request) {
        System.out.println("HandleRuleA");
    }
}
