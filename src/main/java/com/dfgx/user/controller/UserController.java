package com.dfgx.user.controller;


import com.dfgx.user.entity.Student;
import com.dfgx.user.entity.TUser;
import com.dfgx.user.mapper.StudentMapper;
import com.dfgx.user.service.StudentService;
import com.dfgx.user.service.UserService;
import com.dfgx.user.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "用户")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "动态代理技术")
    @GetMapping("/selectByName")
    public void selectByName() {
        StudentService studentProxy = (StudentService)Proxy.newProxyInstance(studentService.getClass().getClassLoader(),
                studentService.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) ->{
                    System.out.println("123456");
                    return method.invoke(studentService,args);
                });
        studentProxy.printName();
        System.out.println(studentProxy.selectByName());
    }


    @ApiOperation(value = "用户查询")
    @PostMapping("/select")
    public List<TUser> select() {
        return userService.select();
    }

    @ApiOperation(value = "用户查询2")
    @PostMapping("/select2")
    @ResponseBody
    public TUser select2() {
        List<TUser> list = userService.select();
        return list.get(0);
    }

    /**
     * @description: todo
     * @Param: [user]
     * @Return: int
     * @Author: Today
     */
    @ApiOperation(value = "用户查询2")
    @PostMapping("/insert")
    public int insert(@RequestBody TUser user) {
        return userService.insert(user);
    }

    @ApiOperation(value = "用户更新数据")
    @PutMapping("/update")
    public int update(@RequestParam Integer id) {
        return userService.update(id);
    }

    @ApiOperation(value = "用户删除数据")
    @DeleteMapping("/delete")
    public int delete(@RequestParam Integer id) {
        return userService.delete(id);
    }

    @ApiOperation(value = "用户插入数据")
    @PostMapping("/insert1")
    public void insert1() throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("1","11","111"));
        list.add(new Student("2","22","222"));
        list.add(new Student("3","33","333"));
        studentMapper.insertList(list);
    }



}
