package com.omega.framework.common.util.spring;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lviter
 * @Description
 * @Date 10:17 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class SpringApplicationContextUtils {

    private static final Logger log = LoggerFactory.getLogger(SpringApplicationContextUtils.class);

    private static ApplicationContext applicationContext;
    private static String contextId;

    public static String getContextId() {
        return contextId;
    }

    public static void setContextId(String contextId) {
        SpringApplicationContextUtils.contextId = contextId;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationContextUtils.applicationContext = applicationContext;
    }

    public static synchronized ApplicationContext getApplicationContext() {
        log.info("SpringApplicationContextUtils getApplicationContext begin");
        if (applicationContext != null) {
            log.info("SpringApplicationContextUtils getApplicationContext get not null");
            return applicationContext;
        } else {
            log.info("SpringApplicationContextUtils getApplicationContext is null, contextId = {}", contextId);
            applicationContext = new ClassPathXmlApplicationContext(contextId == null ? "worker.xml" : contextId);
            return applicationContext;
        }
    }
}
