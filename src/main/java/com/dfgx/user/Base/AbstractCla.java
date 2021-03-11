package com.dfgx.user.Base;

import java.util.*;

/**
 * @description:
 * @Param: 抽象方法有成员方法和成员变量，有抽象方法和构造器，不能直接实例化;
 * 可以被继承但是不能被实现
 * @Return:
 */
public abstract class AbstractCla implements Cloneable{

    private String name;
    private String id;

    public AbstractCla() {
    }

    public AbstractCla(String name){};


    public static void main(String[] args) throws CloneNotSupportedException {
        //break 只能跳出正在作用的循环
        A:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(i+"  "+j);
                break A;
            }
        }

        String k ="5";
        System.out.println(k.hashCode());

        String s3 = "Program";
        String s4= "ming";
        String s5 = "Programming";
        String s6 = s3 + s4;
        System.out.println(s6==s3);//false

        Calendar in = Calendar.getInstance();
        in.set(2021,6,1);//Calender用数字设置月份的时候，是从0开始，这里写6月应该是显示july 7月
        Date time = in.getTime();
        System.out.println(time);


    }

}
