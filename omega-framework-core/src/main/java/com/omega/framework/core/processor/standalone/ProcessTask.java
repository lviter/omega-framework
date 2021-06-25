package com.omega.framework.core.processor.standalone;

import java.io.Serializable;

/**
 * @Description 任务
 * @Author fang
 * @Date 2020-03-07 14:19
 **/
public class ProcessTask implements Serializable {

    private static final long serialVersionUID = 240035162663211986L;
    private String fromNodeId;
    private String toNodeId;
    private Object taskObject;

    public String getFromNodeId() {
        return fromNodeId;
    }

    public void setFromNodeId(String fromNodeId) {
        this.fromNodeId = fromNodeId;
    }

    public String getToNodeId() {
        return toNodeId;
    }

    public void setToNodeId(String toNodeId) {
        this.toNodeId = toNodeId;
    }

    public Object getTaskObject() {
        return taskObject;
    }

    public void setTaskObject(Object taskObject) {
        this.taskObject = taskObject;
    }
}
