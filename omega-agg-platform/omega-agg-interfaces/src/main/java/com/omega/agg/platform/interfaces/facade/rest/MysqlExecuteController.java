package com.omega.agg.platform.interfaces.facade.rest;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lviter
 * @desc:
 * @date:2021/12/7
 */
@Api(tags = "mysql操作引擎")
@RestController(value = "MysqlExecuteController")
@RequestMapping(value = "/api/v1/mysql/exec")
public class MysqlExecuteController {



}
