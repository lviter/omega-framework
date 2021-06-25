package com.omega.framework.core.processor;

import com.omega.framework.core.collector.ICollector;

/**
 * @Description TODO
 * @Author fang
 * @Date 2020-03-07 15:05
 **/
public class ProcessOutput implements IProcessOutput {

    private static final long serialVersionUID = 6357723790550296351L;
    private ICollector collector;

    public void setCollector(ICollector collector) {
        this.collector = collector;
    }

    @Override
    public ICollector getCollector() {
        return this.collector;
    }
}
