package com.neo.thirteen.LambdaTest.Lamda;

/**
 * create by xiaocai on 2021/5/10 14:56
 *
 * [1] 当只用一个参数，可以不需要括号 ()。 然而，这是一个特例。
 * [2] 正常情况使用括号 () 包裹参数。 为了保持一致性，也可以使用括号 () 包裹单个参数，虽然这种情况并不常见。
 * [3] 如果没有参数，则必须使用括号 () 表示空参数列表。
 * [4] 对于多个参数，将参数列表放在括号 () 中。
 **/
public class LambdaExpressions {
    static Body bod = h -> h + " No Parens!"; // [1]

    static Body bod2 = (h) -> h + " More details"; // [2]

    static Description desc = () -> "Short info"; // [3]

    static Multi mult = (h, n) -> h + n; // [4]

    static Description moreLines = () -> { // [5]
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}