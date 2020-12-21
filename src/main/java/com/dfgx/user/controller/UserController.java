package com.dfgx.user.controller;


import com.dfgx.user.pojo.TUser;
import com.dfgx.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value ="用户查询" )
    @GetMapping("/select")
    @ResponseBody
    public List<TUser> select(){
        return userService.select();
    }
}