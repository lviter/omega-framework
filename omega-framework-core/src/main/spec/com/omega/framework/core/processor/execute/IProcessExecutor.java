package com.omega.framework.core.processor.execute;

import com.omega.framework.core.processor.config.ProcessorGraph;

/**
 * @Author lviter
 * @Description 过程执行器
 * @Date 11:20 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface IProcessExecutor {

    void execute(ProcessorGraph processorGraph, String... args) throws Exception;
}
