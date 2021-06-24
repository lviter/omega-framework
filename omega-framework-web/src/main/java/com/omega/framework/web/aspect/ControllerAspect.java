package com.omega.framework.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author lviter
 * @Description
 * @Date 14:35 2021/6/24
 * @Desc: Warning!Warning!!Warning!!!
 **/
@Aspect
@Configuration
@Slf4j
public class ControllerAspect {
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.omega.framework..controller.*Controller.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void executeBefore(JoinPoint joinPoint) {
        executeMethod(joinPoint);
    }

    @AfterReturning(returning = "o", pointcut = "webLog()")
    public void executeAfterReturning(Object o) {
        executeMethod();
    }

    private void executeMethod(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (!ObjectUtils.isEmpty(servletRequestAttributes)) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            log.info("请求地址 :{}", request.getRequestURL().toString());
            log.info("请求方式 :{} ", request.getMethod());
            log.info("IP :{} ", request.getRemoteAddr());
            log.info("匹配方法 :{} ", joinPoint.getSignature().getDeclaringTypeName().concat(joinPoint.getSignature().getName()));
            log.info("方法参数 :{} ", Arrays.toString(joinPoint.getArgs()));
        }
    }

    private void executeMethod() {
        log.info("接口耗时: {}", ((System.currentTimeMillis() - startTime.get()) + "ms."));
        startTime.remove();
    }
}
