package com.omega.agg.platform.interfaces.facade.rest;

import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import com.omega.agg.platform.interfaces.dto.user.UserInfoDTO;
import com.omega.agg.platform.interfaces.dto.user.UserLoginDTO;
import com.omega.framework.common.pojo.dto.OmegaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author: lviter
 * @desc:
 * @date:2021/11/23
 */

@Api(tags = "用户操作控制器")
@RestController(value = "UserController")
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @ApiOperation(value = "登录", notes = "post", response = String.class, httpMethod = "POST")
    @PostMapping(value = "/login")
    public OmegaResult<String> login(@RequestBody UserLoginDTO loginForm) {
        return OmegaResult.ok("Hello:" + loginForm.getUsername() + "password:" + loginForm.getPassword());
    }


    @ApiOperation(value = "用户基础信息", notes = "get请求", response = String.class, httpMethod = "GET")
    @GetMapping(value = "/info")
    public OmegaResult<UserInfoDTO> info(@RequestParam(value = "token") String token) {
        if (token.equals("admin-token")) {
            return OmegaResult.ok(new UserInfoDTO(CollectionUtils.newArrayList("admin"), "I am a super administrator", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif", "Super Admin"));
        }
        return OmegaResult.ok(new UserInfoDTO());
    }
}
