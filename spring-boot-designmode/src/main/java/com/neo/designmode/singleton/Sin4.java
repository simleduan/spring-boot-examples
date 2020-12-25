package com.neo.designmode.singleton;

/**
 * create by xiaocai on 2020/12/22 14:51
 **/
public class Sin4 {
    private static Sin4 instance;

    private Sin4() {
    }

    public synchronized static Sin4 getInstance(){
        if (instance==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Sin4();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Sin4.getInstance().hashCode());
            }).start();
        }
    }
}
