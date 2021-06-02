package com.neo.thirteen.aonymousClasses;

/**
 * create by xiaocai on 2021/5/10 14:25
 * 案例二，匿名内部类的属性屏蔽：
 **/
public class ShadowTestTwo {
    public int x = 0;

    interface FirstLevel {
        void methodInFirstLevel(int x);
    }

    FirstLevel firstLevel =  new FirstLevel() {

        public int x = 1;

        @Override
        public void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTestTwo.this.x);
        }
    };

    public static void main(String... args) {
        ShadowTestTwo st = new ShadowTestTwo();
        ShadowTestTwo.FirstLevel fl = st.firstLevel;
        fl.methodInFirstLevel(23);
    }
}
