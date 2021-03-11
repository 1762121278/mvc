package com.dfgx.user.Thread;

import lombok.SneakyThrows;

/**
 * @author Today
 */
public class MyRun implements Runnable{

    @Override
    public void run() {
            for (int i = 1 ; i <= 20 ; i++ ) {
                System.out.println(Thread.currentThread().getName()+i);
                Thread.yield();
            }
    }

    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread mythread1 = new Thread(myRun,"线程数三");
        Thread mythread2 = new Thread(myRun,"线程数四");

        //数字越大线程的优先级越高
        mythread1.start();
        mythread2.start();
    }
}
