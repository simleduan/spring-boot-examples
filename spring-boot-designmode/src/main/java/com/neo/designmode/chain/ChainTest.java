package com.neo.designmode.chain;

/**
 * create by xiaocai on 2021/1/4 11:36
 **/
public class ChainTest {
    public static void main(String[] args) {
        HandleRuleA handleRuleA = new HandleRuleA(1);
        HandleRuleB handleRuleB = new HandleRuleB(2);
        handleRuleA.setNexeHandler(handleRuleB);
        handleRuleA.echo(new Request());
    }
}
