package com.neo.designmode.factory;

/**
 * create by xiaocai on 2020/9/18 17:55
 **/
public class LowerFactory implements IFactory {
    @Override
    public void creatMask() {
        LowerMask lowerMask = new LowerMask();
        lowerMask.showMask();
    }

    @Override
    public void createProtectiveSuit() {
        LowerProtectiveSuit lowerProtectiveSuit = new LowerProtectiveSuit();
        lowerProtectiveSuit.showSuit();
    }
}
