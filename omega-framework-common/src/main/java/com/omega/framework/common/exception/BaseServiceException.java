package com.omega.framework.common.exception;

/**
 * @Author lviter
 * @Description
 * @Date 17:32 2021/6/23
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface BaseServiceException {
    /**
     * 获取异常状态码
     */
    String getCode();

    /**
     * 获取异常提示信息
     */
    String getMessage();
}
