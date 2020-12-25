package com.neo.designmode.singleton;

/**
 * create by xiaocai on 2020/12/22 15:02
 * 静态内部类写法，JVM保证唯一性
 **/
public class Sin6 {
    private Sin6() {
    }
    private static class Sin6Holder{
        private static Sin6 instance = new Sin6();
    }
    public static Sin6 getInstance(){
        return Sin6Holder.instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Sin6.getInstance().hashCode());
            }).start();
        }
    }
}
