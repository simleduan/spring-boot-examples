package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:02
 **/
public class NewUserRewardStrategy extends RewardStrategy {
    @Override
    int rewardCalculate(GodUser godUser) {
        System.out.println("新用户的返奖策略");
        return 100;
    }
}
