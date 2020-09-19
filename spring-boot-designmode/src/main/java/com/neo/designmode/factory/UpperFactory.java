package com.neo.designmode.factory;

/**
 * create by xiaocai on 2020/9/18 17:56
 **/
public class UpperFactory implements IFactory {
    @Override
    public void creatMask() {
        UpperMask upperMask = new UpperMask();
        upperMask.showMask();
    }

    @Override
    public void createProtectiveSuit() {
        UpperProtectiveSuit upperProtectiveSuit = new UpperProtectiveSuit();
        upperProtectiveSuit.showSuit();
    }
}
