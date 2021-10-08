package com.neo.thirteen.aonymousClasses;

/**
 * create by xiaocai on 2021/5/10 14:27
 *
 * 匿名内部类中不能定义静态属性、方法；　　
 *
 **/
public class ShadowTestThree {
    public int x = 0;

    interface FirstLevel {
        void methodInFirstLevel(int x);
    }

    FirstLevel firstLevel =  new FirstLevel() {

        @Override
        public void methodInFirstLevel(int x) {

        }

        public int x = 1;

//        public static String str = "Hello World";   // 编译报错

//        public static void aa() {        // 编译报错
//        }

        public static final String finalStr = "Hello World";  // 正常

        public void extraMethod() {  // 正常
            // do something
        }
    };
}
