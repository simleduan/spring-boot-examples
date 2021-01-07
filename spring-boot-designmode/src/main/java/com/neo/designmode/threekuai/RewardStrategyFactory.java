package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:03
 * 返奖抽象策略工厂
 **/
public abstract class RewardStrategyFactory<T> {
   abstract RewardStrategy createRewardStrategy(Class<T> clz);
}
