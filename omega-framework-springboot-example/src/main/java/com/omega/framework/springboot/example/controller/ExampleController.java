package com.omega.framework.springboot.example.controller;

import com.omega.framework.common.exception.ServiceException;
import com.omega.framework.common.pojo.dto.OmegaResult;
import com.omega.framework.common.util.spring.SpringApplicationContextUtils;
import com.omega.framework.springboot.example.service.SqlBaseService;
import com.omega.framework.web.enums.ApiErrorCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.StampedLock;

@Api(tags = "示例控制器")
@RestController(value = "ExampleController")
@RequestMapping(value = "/v1/example/")
public class ExampleController {

    private final RestTemplate restTemplate;
    private final SqlBaseService sqlBaseService;

    public ExampleController(RestTemplate restTemplate, SqlBaseService sqlBaseService) {
        this.restTemplate = restTemplate;
        this.sqlBaseService = sqlBaseService;
    }

    @ApiImplicitParam(name = "word", value = "一个文本")
    @ApiOperation(value = "get获取一个字符", notes = "get请求", response = String.class, httpMethod = "GET")
    @GetMapping(value = "/word")
    public OmegaResult<String> getString(@RequestParam(value = "word", required = false) String word) {
        if (StringUtils.isNotBlank(word))
            return OmegaResult.ok(word);
        StampedLock stampedLock = new StampedLock();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {

            }
        });
        List<String> stringList = new ArrayList<>();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
//        copyOnWriteArrayList.add()
        Map<String, String> map
                = new HashMap<>(15);
        map.put("", "");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("", "");
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        concurrentSkipListMap.put("", "");
        return OmegaResult.fail(new ServiceException(ApiErrorCodeEnum.SYS_PLACEHOLDER_TEST, "lvl"));
    }

    @ApiOperation(value = "调用一个接口", notes = "get请求", response = String.class, httpMethod = "GET")
    @GetMapping(value = "/invoke")
    public OmegaResult<String> invokeApi(@RequestParam(value = "url") String url) {
        String res = restTemplate.getForObject(url, String.class);
        return OmegaResult.ok(res);
    }

    @ApiOperation(value = "测试数据库")
    @GetMapping(value = "invokeTest")
    public OmegaResult<Integer> invokeTest() {
        return OmegaResult.ok(sqlBaseService.saveData());
    }

}
