package com.dfgx.user.Thread;

import lombok.SneakyThrows;

/**
 * @author Today
 */
public class Mythread extends Thread{


    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0 ; i <=10 ; i++ ) {
            System.out.println(currentThread().getName()+i);
            sleep(1000);
        }
    }

    public static void main(String[] args) {
        Mythread mythread1 = new Mythread();
        Mythread mythread2 = new Mythread();
        mythread1.setName("线程一");
        mythread2.setName("线程二");
        MyRun myRun = new MyRun();
        Thread mythread3 = new Thread(myRun,"线程数三");
        Thread mythread4 = new Thread(myRun,"线程数四");
        //数字越大线程的优先级越高

        mythread1.start();
        mythread2.start();

        //打印结果如下
        /*
        线程二0
        线程二1
        线程二2
        线程二3
        线程一0
        线程一1
        线程一2
        线程一3
        */

        mythread3.start();
        mythread4.start();
    }
}
