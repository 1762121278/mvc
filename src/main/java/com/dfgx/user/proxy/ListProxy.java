package com.dfgx.user.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Today
 * ArrayList的动态代理类
 */
public class ListProxy {

    public  static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(list,args);
                    }
                });
        list1.add("123");
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list==list1);
    }

}
