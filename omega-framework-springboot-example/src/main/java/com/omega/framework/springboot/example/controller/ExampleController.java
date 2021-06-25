package com.omega.framework.springboot.example.controller;

import com.omega.framework.common.exception.ServiceException;
import com.omega.framework.common.pojo.dto.OmegaResult;
import com.omega.framework.common.util.spring.SpringApplicationContextUtils;
import com.omega.framework.web.enums.ApiErrorCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "示例控制器")
@RestController(value = "ExampleController")
@RequestMapping(value = "/v1/example/")
public class ExampleController {

    @ApiImplicitParam(name = "word", value = "一个文本")
    @ApiOperation(value = "get获取一个字符", notes = "get请求", response = String.class, httpMethod = "GET")
    @GetMapping(value = "/word")
    public OmegaResult<String> getString(@RequestParam(value = "word", required = false) String word) {
        if (StringUtils.isNotBlank(word))
            return OmegaResult.ok(word);
        return OmegaResult.fail(new ServiceException(ApiErrorCodeEnum.SYS_PLACEHOLDER_TEST, "lvl"));
    }


}
