package com.neo.designmode.state;

/**
 * create by xiaocai on 2021/1/4 10:57
 * 状态模式，从https://tech.meituan.com/2020/03/19/design-pattern-practice-in-marketing.html学习的
 **/
public abstract class State {
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handle1();
    public abstract void handle2();
}
