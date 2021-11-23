package com.omega.framework.springboot.example.controller;

import com.omega.framework.common.pojo.dto.OmegaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lviter
 * @desc:
 * @date:2021/11/23
 */

@Api(tags = "示例控制器-登录")
@RestController(value = "UserController")
@RequestMapping(value = "/user")
public class UserController {

    @ApiOperation(value = "调用一个接口", notes = "get请求", response = String.class, httpMethod = "GET")
    @PostMapping(value = "/login")
    public OmegaResult<String> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return OmegaResult.ok("Hello:" + username + "password:" + password);
    }
}
