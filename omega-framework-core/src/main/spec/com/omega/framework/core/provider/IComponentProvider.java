package com.omega.framework.core.provider;

import java.io.Serializable;

/**
 * @Author lviter
 * @Description 对象提供器
 * @Date 9:53 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface IComponentProvider extends Serializable {

    /**
     * 获取组件对象
     *
     * @param componentId
     * @return
     */
    Object getComponent(String componentId);
}
