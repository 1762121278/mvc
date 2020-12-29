package com.dfgx.user.controller;

import com.dfgx.user.validate.Bean.DeptParam;
import com.dfgx.user.validate.Bean.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api(tags = "用于校验的接口")
public class ValidationController {

    @PostMapping("/validate")
    @ApiOperation(value = "校验的方法")
    public Result validate(@Valid @RequestBody DeptParam dept) {
        dept.getRemark();
        return Result.SUCCESS;
    }
}
