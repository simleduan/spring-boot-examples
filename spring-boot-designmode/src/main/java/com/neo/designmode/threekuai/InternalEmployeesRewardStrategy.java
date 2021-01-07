package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:49
 **/
public class InternalEmployeesRewardStrategy extends RewardStrategy {
    @Override
    int rewardCalculate(GodUser godUser) {
        System.out.println("这里是内部员工");
        return 150;
    }
}
