package com.dfgx.user.Thread.ThreadPool;

import java.util.HashMap;
import java.util.concurrent.*;

public class ThreadPoolPro {
    public  void main(){
        //创建可缓存线程池
       ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(new RunAble(){
                @Override
                public synchronized void run() {
                    System.out.println(Thread.currentThread().getName() +"正在执行");
                }
            });

        }

    }

    public static void main(String[] args){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        //延迟1秒执行
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                HashMap<String,String> hashMap = new HashMap<String,String>();
                hashMap.put("a","1");
                hashMap.put("b","2");
                hashMap.put("c","3");
                hashMap.put("d","4");

                System.out.println(Thread.currentThread().getName() +"延迟2秒执行");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }


}
