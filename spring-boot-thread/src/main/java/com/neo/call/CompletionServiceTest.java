package com.neo.call;

import java.util.Random;
import java.util.concurrent.*;

/**
 * create by xiaocai on 2021/1/6 15:57
 **/
public class CompletionServiceTest {
    public static void main(String[] args) throws Exception {

        /**
         * 内部维护11个线程的线程池
         */
        ExecutorService exec = Executors.newFixedThreadPool(3);
        /**
         * 容量为10的堵塞队列
         */
        final BlockingQueue<Future<Integer>> queue = new LinkedBlockingDeque<Future<Integer>>(
                10);
        //实例化CompletionService
        final CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
                exec, queue);

        for (int i=0;i<10;i++){
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int ran = new Random().nextInt(1000);
                    Thread.sleep(ran);
                    System.out.println(Thread.currentThread().getName() + " 歇息了 " + ran);
                    return ran;
                }
            });
        }

        for (int i=0;i<10;i++){
            Future<Integer> take = completionService.take();
            System.out.println(take.get());
        }

        exec.shutdown();
    }
}
