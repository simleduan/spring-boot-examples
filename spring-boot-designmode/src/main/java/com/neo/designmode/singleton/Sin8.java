package com.neo.designmode.singleton;

/**
 * create by xiaocai on 2020/12/22 15:15
 * 双重检查
 **/
public class Sin8 {
    private static volatile Sin8 instance;//volatile是为了指令重排序

    private Sin8() {
    }

    public static Sin8 getInstance(){
        if (instance==null){
            synchronized (Sin8.class){
                if (instance==null){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Sin8();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Sin8.getInstance().hashCode());
            }).start();
        }
    }
}
