package com.omega.agg.platform.controller;

import com.omega.framework.common.pojo.dto.OmegaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lviter
 * @desc:
 * @date:2021/11/23
 */

@Api(tags = "用户操作控制器")
@RestController(value = "UserController")
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @ApiOperation(value = "调用一个接口", notes = "get请求", response = String.class, httpMethod = "GET")
    @PostMapping(value = "/login")
    public OmegaResult<String> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return OmegaResult.ok("Hello:" + username + "password:" + password);
    }
}
