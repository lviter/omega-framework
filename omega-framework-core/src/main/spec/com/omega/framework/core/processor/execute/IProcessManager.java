package com.omega.framework.core.processor.execute;

import com.omega.framework.core.processor.config.ProcessorGraph;

import java.util.List;

/**
 * @Author lviter
 * @Description 过程管理器
 * @Date 11:18 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface IProcessManager {

    /**
     * 设置执行器
     *
     * @param executor
     */
    void setExecutor(IProcessExecutor executor);

    /**
     * 获取执行器
     *
     * @return
     */
    IProcessExecutor getExecutor();

    /**
     * 执行过程
     *
     * @param processId
     * @param args
     * @throws Exception
     */
    void executeProcesses(String processId, String... args) throws Exception;

    /**
     * 注册过程
     *
     * @param processorGraph
     */
    void registerProcess(ProcessorGraph processorGraph);

    /**
     * 获取过程
     *
     * @return
     */
    List<ProcessorGraph> getProcesses();

}
