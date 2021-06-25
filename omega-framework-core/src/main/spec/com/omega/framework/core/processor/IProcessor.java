package com.omega.framework.core.processor;

import java.io.Serializable;

/**
 * @Author lviter
 * @Description 处理器顶级
 * @Date 15:42 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface IProcessor extends Serializable {

    void activate(IProcessActivateContext activateContext) throws Exception;

    void deactivate() throws Exception;

    void process(IProcessInput input, IProcessOutput output) throws Exception;

}