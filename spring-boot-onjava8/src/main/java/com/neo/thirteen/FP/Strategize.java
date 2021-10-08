package com.neo.thirteen.FP;

/**
 * create by xiaocai on 2021/5/10 10:56
 *
 * [1] 在 Strategize 中，你可以看到 Soft 作为默认策略，在构造函数中赋值。
 * [2] 一种较为简洁且更加自然的方法是创建一个匿名内部类。即便如此，仍有相当数量的冗余代码。你总需要仔细观察后才会发现：“哦，我明白了，原来这里使用了匿名内部类。”
 * [3] Java 8 的 Lambda 表达式，其参数和函数体被箭头 -> 分隔开。箭头右侧是从 Lambda 返回的表达式。它与单独定义类和采用匿名内部类是等价的，但代码少得多。
 * [4] Java 8 的方法引用，它以 :: 为特征。 :: 的左边是类或对象的名称， :: 的右边是方法的名称，但是没有参数列表。
 * [5] 在使用默认的 Soft 策略之后，我们逐步遍历数组中的所有 Strategy，并通过调用 changeStrategy() 方法将每个 Strategy 传入变量 s 中。
 * [6] 现在，每次调用 communicate() 都会产生不同的行为，具体取决于此刻正在使用的策略代码对象。我们传递的是行为，而并不仅仅是数据。
 **/
public class Strategize {
    Strategy strategy;
    String msg;
    Strategize(String msg) {
        strategy = new Soft(); // [1]
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() { // [2]
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0, 5), // [3]
                Unrelated::twice // [4]
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for(Strategy newStrategy : strategies) {
            s.changeStrategy(newStrategy); // [5]
            s.communicate(); // [6]
        }
    }
}

