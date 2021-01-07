package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:02
 **/
public class OldUserRewardStrategy extends RewardStrategy {
    @Override
    int rewardCalculate(GodUser godUser) {
        System.out.println("老用户的返奖策略");
        return 200;
    }
}
