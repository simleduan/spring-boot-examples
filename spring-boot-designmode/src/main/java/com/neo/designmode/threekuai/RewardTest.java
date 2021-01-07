package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:09
 * FactorRewardStrategyFactory 具体工厂具体策略，使用泛型后，不用单独创建。
 * 策略模式通过Context产生唯一一个ConcreteStrategy作用于代码中
 **/
public class RewardTest {
    public static int rewardCalcution(GodUser godUser){
        //创建工厂
        int reward = 0;
        FactorRewardStrategyFactory strategyFactory = new FactorRewardStrategyFactory();
        if (godUser.getUserType().equals("NEW_USER")){
            RewardStrategy strategy = strategyFactory.createRewardStrategy(NewUserRewardStrategy.class);
            RewardContext context = new RewardContext(strategy);
            reward = context.rewardCalculate(godUser);
        } else if (godUser.getUserType().equals("OLD_USER")){
            RewardStrategy strategy = strategyFactory.createRewardStrategy(OldUserRewardStrategy.class);
            RewardContext context = new RewardContext(strategy);
            reward = context.rewardCalculate(godUser);
        } else if (godUser.getUserType().equals("INTER_EMP")){
            RewardStrategy strategy = strategyFactory.createRewardStrategy(InternalEmployeesRewardStrategy.class);
//            策略模式通过Context产生唯一一个ConcreteStrategy作用于代码中
            RewardContext context = new RewardContext(strategy);
            reward = context.rewardCalculate(godUser);
        }
        return reward;
    }

    public static void main(String[] args) {
        GodUser godUser = new GodUser(100, "INTER_EMP");
        int i = rewardCalcution(godUser);
        System.out.println(i);
    }
}
