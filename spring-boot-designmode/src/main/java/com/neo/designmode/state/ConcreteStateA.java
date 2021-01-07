package com.neo.designmode.state;

/**
 * create by xiaocai on 2021/1/4 10:58
 **/
public class ConcreteStateA extends State{
    //本状态下必须要处理的事情
    @Override
    public void handle1() {
        System.out.println("ConcreteStateA  必须要处理的事情");
    }

    @Override
    public void handle2() {
        super.context.setCurrentState(Context.concreteStateB);//切换到状态B
        super.context.handle2();//执行状态B的任务
    }
}
