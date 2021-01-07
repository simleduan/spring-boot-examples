package com.neo.designmode.state;

/**
 * create by xiaocai on 2021/1/4 10:58
 **/
public class ConcreteStateB extends State{
    //本状态下必须要处理的事情
    @Override
    public void handle1() {
        super.context.setCurrentState(Context.concreteStateA);//切换刚到状态A
        super.context.handle1();//执行状态A的任务
    }

    @Override
    public void handle2() {
        System.out.println("ConcreteStateB  必须要处理的事情");
    }
}
