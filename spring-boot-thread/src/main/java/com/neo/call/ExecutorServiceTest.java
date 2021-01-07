package com.neo.call;

import java.util.concurrent.*;

/**
 * create by xiaocai on 2021/1/6 16:18
 **/
public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ExecutorCompletionService<Long> completionService = new ExecutorCompletionService<>(executorService);
        final int groupNum = 100/10; //100000000
//        final int groupNum = 10000000/100;
        for (int i=1;i<=groupNum;i++){
            int start = (i-1)*groupNum+1,end = i*groupNum;
            completionService.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    System.out.println("start:"+start+" end:"+end + " Thread："+Thread.currentThread().getName());
                    Long sum = 0l;
                    for (int j=start;j<=end;j++){
                        sum+=j;
                    }
                    return sum;
                }
            });
        }
        long result = 0l;
        for (int i=1;i<=groupNum;i++){
            result+=completionService.take().get();
        }
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("最后相加结果为："+result +" 执行时间为："+(end - begin));
    }
}
