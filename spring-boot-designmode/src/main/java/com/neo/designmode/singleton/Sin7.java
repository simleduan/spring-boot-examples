package com.neo.designmode.singleton;

/**
 * 解决线程同步和反序列化
 * 枚举类没有构造方法，所以不会被反序列化
 */
public enum Sin7 {
    INSTANCE;
    public void method(){
        System.out.println("my method");
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println(Sin7.INSTANCE.hashCode());
        }
    }
}
