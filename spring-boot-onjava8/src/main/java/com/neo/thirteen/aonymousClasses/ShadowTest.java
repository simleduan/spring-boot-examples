package com.neo.thirteen.aonymousClasses;

/**
 * create by xiaocai on 2021/5/10 14:18
 * 案例一，内嵌类的属性屏蔽
 * ShadowTest实例中有三个变量x
 *  第一、ShadowTest类的成员变量x
 *  第二、FirstLevel内部类的成员变量x
 *  第三、内部类方法methodInFirstLevel的参数。
 *
 **/
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);//参数
            System.out.println("this.x = " + this.x);//内部类成员变量
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);//外部类成员变量
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }

    /*这个实例中有三个变量x：1、ShadowTest类的成员变量；2、内部类FirstLevel的成员变量；3、内部类方法methodInFirstLevel的参数。

    methodInFirstLevel的参数x屏蔽了内部类FirstLevel的成员变量，因此，在该方法内部使用x时实际上是使用的是参数x，
    可以使用this关键字来指定引用是成员变量x：
    System.out.println("this.x = " + this.x);

    利用类名来引用其成员变量拥有最高的优先级，不会被其他同名变量屏蔽，如：
    System.out.println("ShadowTest.this.x = " + ShadowTest.this.x); */
}
