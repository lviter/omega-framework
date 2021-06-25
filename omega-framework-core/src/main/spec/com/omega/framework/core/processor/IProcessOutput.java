
package com.omega.framework.core.processor;


import com.omega.framework.core.collector.ICollector;

import java.io.Serializable;

/**
 * @Author lviter
 * @Description 包含处理器所需要物料
 * @Date 15:42 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface IProcessOutput extends Serializable {

    ICollector getCollector();

}

