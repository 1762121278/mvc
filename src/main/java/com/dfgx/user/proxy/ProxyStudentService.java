package com.dfgx.user.proxy;

import com.dfgx.user.entity.Student;
import com.dfgx.user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Today
 */
@Component
@Configuration
public class ProxyStudentService implements InvocationHandler {

    @Autowired
    private StudentService studentService;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        method.invoke(studentService,args);
        return null;
    }
}
