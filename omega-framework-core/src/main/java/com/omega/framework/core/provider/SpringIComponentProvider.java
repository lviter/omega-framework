package com.omega.framework.core.provider;

import com.omega.framework.common.util.spring.SpringApplicationContextUtils;

/**
 * @Author lviter
 * @Description
 * @Date 10:14 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class SpringIComponentProvider implements IComponentProvider {
    @Override
    public Object getComponent(String componentId) {
        if (SpringApplicationContextUtils.getApplicationContext() == null) {
            throw new RuntimeException("SpringApplicationContextUtils not found context");
        }
        return SpringApplicationContextUtils.getApplicationContext().getBean(componentId);
    }
}
