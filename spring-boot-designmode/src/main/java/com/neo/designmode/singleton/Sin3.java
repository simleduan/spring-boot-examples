package com.neo.designmode.singleton;

/**
 * create by xiaocai on 2020/12/22 14:51
 **/
public class Sin3 {
    private static Sin3 instance;

    private Sin3() {
    }

    public static Sin3 getInstance(){
        if (instance==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Sin3();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Sin3.getInstance().hashCode());
            }).start();
        }
    }
}
