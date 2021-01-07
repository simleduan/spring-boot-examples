package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:17
 **/
public class FactorRewardStrategyFactory extends RewardStrategyFactory {
    @Override
    RewardStrategy createRewardStrategy(Class clz) {
        RewardStrategy rewardStrategy = null;
        try{
            rewardStrategy = (RewardStrategy) Class.forName(clz.getName()).newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rewardStrategy;
    }
}
