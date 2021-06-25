package com.omega.framework.core.provider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author lviter
 * @Description
 * @Date 9:57 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class ClassInstantiationIComponentProvider implements IComponentProvider {

    private static final Logger log = LoggerFactory.getLogger(ClassInstantiationIComponentProvider.class);

    @Override
    public Object getComponent(String componentId) {
        log.info("Omega framework core ClassInstantiationComponentProvider getComponent begin");
        try {
            Class<?> clz = Class.forName(componentId, true, this.getClass().getClassLoader());
            if (clz != null) {
                log.info("Omega framework core ClassInstantiationComponentProvider getComponent class get instance");
                return clz.newInstance();
            }
        } catch (Exception e) {
            log.info("Omega framework core ClassInstantiationComponentProvider getComponent exception");
            throw new RuntimeException(e);
        }
        return null;
    }
}
