package com.omega.framework.core.processor;

/**
 */
public class ProcessActivateContext implements IProcessActivateContext {

    private Class outputType;

    public Class getOutputType() {
        return outputType;
    }

    public void setOutputType(Class outputType) {
        this.outputType = outputType;
    }
}
