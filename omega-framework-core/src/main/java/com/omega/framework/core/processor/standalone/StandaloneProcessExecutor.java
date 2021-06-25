package com.omega.framework.core.processor.standalone;


import com.omega.framework.core.processor.config.ProcessorGraph;
import com.omega.framework.core.processor.execute.IProcessExecutor;
import com.omega.framework.core.provider.IComponentProvider;

/**
 * @Author lviter
 * @Description Standalone模式ProcessExecutor
 * @Date 15:36 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class StandaloneProcessExecutor implements IProcessExecutor {

    private IComponentProvider componentProvider;

    public StandaloneProcessExecutor(IComponentProvider componentProvider) {
        this.componentProvider = componentProvider;
    }

    @Override
    public void execute(ProcessorGraph processGraph, String... args) throws Exception {
        StandaloneProcessActuator actuator = new StandaloneProcessActuator(this.componentProvider);
        actuator.setMaxPending(100000);
        actuator.initialize(processGraph, args);
        actuator.launch();
    }
}
