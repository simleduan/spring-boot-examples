package com.neo.designmode.state;

/**
 * create by xiaocai on 2021/1/4 11:18
 **/
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
//        context.handle1();
        context.handle2();
    }
}
