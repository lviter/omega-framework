package com.omega.agg.platform.controller;

import com.omega.framework.common.pojo.dto.OmegaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lviter
 * @desc:
 * @date:2021/11/23
 */
@Api(tags = "示例控制器")
@RestController(value = "ExampleController")
@RequestMapping(value = "/api/v1/example")
public class ExampleController {

    @ApiOperation(value = "ping下服务", notes = "get请求", response = String.class, httpMethod = "GET")
    @GetMapping(value = "/ping")
    public OmegaResult<String> ping() {
        return OmegaResult.ok("pong");
    }
}
