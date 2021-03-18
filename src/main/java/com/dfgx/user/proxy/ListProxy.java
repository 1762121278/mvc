package com.dfgx.user.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Today
 * ArrayList的动态代理类
 */
public class ListProxy {

    public  static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //lambda表达式，或者是匿名内部类
        List<String> list1 = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                (proxy, method, args1) -> method.invoke(list, args1));
        list1.add("123");
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list==list1);
    }
}
