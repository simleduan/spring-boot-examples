package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:08
 **/
public class RewardContext {
    private RewardStrategy rewardStrategy;

    public RewardContext(RewardStrategy rewardStrategy) {
        this.rewardStrategy = rewardStrategy;
    }

    public int rewardCalculate(GodUser godUser){
        return rewardStrategy.rewardCalculate(godUser);
    }
}
