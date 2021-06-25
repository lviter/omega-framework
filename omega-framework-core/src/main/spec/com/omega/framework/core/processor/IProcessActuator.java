
package com.omega.framework.core.processor;


import com.omega.framework.core.processor.config.ProcessorGraph;

/**
 * @Author lviter
 * @Description 用于执行processor graph
 * @Date 15:39 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface IProcessActuator {

    void initialize(ProcessorGraph graph, String... args);

    void launch() throws Exception;

    void shutdown() throws Exception;

    boolean isLaunched();

}
