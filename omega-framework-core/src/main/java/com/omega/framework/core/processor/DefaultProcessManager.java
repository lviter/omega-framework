package com.omega.framework.core.processor;

import com.omega.framework.core.processor.config.ProcessorGraph;
import com.omega.framework.core.processor.execute.IProcessExecutor;
import com.omega.framework.core.processor.execute.IProcessManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lviter
 * @Description
 * @Date 11:17 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class DefaultProcessManager implements IProcessManager {
    private static final Logger log = LoggerFactory.getLogger(DefaultProcessManager.class);
    private IProcessExecutor processExecutor;
    private List<ProcessorGraph> processGraphs;

    public DefaultProcessManager() {
        this.processGraphs = new ArrayList<ProcessorGraph>();
    }

    @Override
    public void setExecutor(IProcessExecutor executor) {
        this.processExecutor = executor;
    }

    @Override
    public IProcessExecutor getExecutor() {
        return this.processExecutor;
    }

    @Override
    public void executeProcesses(String processId, String... args) throws Exception {
        if (StringUtils.isBlank(processId)) {
            throw new Exception("DefaultProcessManager is no process with Id[" + processId + "]");
        }
        log.info("omega DefaultProcessManager executeProcesses is processId:{}", processId);
        ProcessorGraph graph = null;
        for (ProcessorGraph g : this.processGraphs) {
            if (processId.equals(g.getGraphId())) {
                graph = g;
                break;
            }
        }
        if (graph == null) {
            throw new Exception("There is no process with Id[" + processId + "]");
        }
        this.processExecutor.execute(graph, args);
    }

    @Override
    public void registerProcess(ProcessorGraph processorGraph) {
        if (processorGraph != null) {
            log.info("omega DefaultProcessManager registerProcess");
            this.processGraphs.add(processorGraph);
        }
    }

    @Override
    public List<ProcessorGraph> getProcesses() {
        return this.processGraphs;
    }
}
