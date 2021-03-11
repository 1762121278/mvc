package com.dfgx.user.Thread.ThreadPool;

public class RunAble implements Runnable{
    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("执行顺序"+i);
        }
    }

}
