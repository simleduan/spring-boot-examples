package com.neo.designmode.singleton;

/**
 * create by xiaocai on 2020/12/22 14:51
 **/
public class Sin5 {
    private static Sin5 instance;

    private Sin5() {
    }

    public static Sin5 getInstance(){
        if (instance==null){
            synchronized (Sin5.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Sin5();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Sin5.getInstance().hashCode());
            }).start();
        }
    }
}
