package com.dfgx.user.controller;


import com.dfgx.user.entity.TUser;
import com.dfgx.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @description: todo
     * @Param: []
     * @Return: java.util.List<com.dfgx.user.entity.TUser>
     * @Author: Today
     */
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

    @PutMapping("/update")
    public int update(@RequestParam Integer id) {
        return userService.update(id);
    }

    @DeleteMapping("/delete")
    public int delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
}
