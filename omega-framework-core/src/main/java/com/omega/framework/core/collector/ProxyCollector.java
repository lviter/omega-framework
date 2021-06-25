package com.omega.framework.core.collector;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lviter
 * @Description
 * @Date 10:41 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class ProxyCollector implements ICollector {
    private ICollector delegateCollector;
    private AtomicInteger counter;

    public ProxyCollector(ICollector delegateCollector) {
        this.delegateCollector = delegateCollector;
        this.counter = new AtomicInteger(0);
    }

    @Override
    public void collect(Object object) {
        if (object != null) {
            this.counter.getAndIncrement();
        }
        this.delegateCollector.collect(object);
    }

    public int getCollectedSize() {
        return this.counter.get();
    }
}
