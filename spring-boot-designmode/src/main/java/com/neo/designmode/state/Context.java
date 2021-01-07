package com.neo.designmode.state;

/**
 * create by xiaocai on 2021/1/4 11:01
 * 定义一个上下文管理环境
 * 对比策略模式的类型会发现和状态模式的类图很类似，但实际上有很大的区别，
 * 具体体现在concrete class上。
 * 策略模式通过Context产生唯一一个ConcreteStrategy作用于代码中，
 * 而状态模式则是通过context组织多个ConcreteState形成一个状态转换图来实现业务逻辑。
 **/
public class Context {
    public static final ConcreteStateA concreteStateA = new ConcreteStateA();
    public static final ConcreteStateB concreteStateB = new ConcreteStateB();
    State currentState;//当前状态
    public State getCurrentState(){
        return currentState;
    }
    //设置当前状态
    public void setCurrentState(State currentState){
        this.currentState = currentState;
        this.currentState.setContext(this);
    }
    public void handle1(){
        this.currentState.handle1();
    }
    public void handle2(){
        this.currentState.handle2();
    }

}
