package com.omega.framework.web.handler;

import com.omega.framework.common.exception.ServiceException;
import com.omega.framework.common.pojo.dto.OmegaRs;
import com.omega.framework.common.pojo.dto.OmegaRsHeader;
import com.omega.framework.web.enums.ApiErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author lviter
 * @Description
 * @Date 18:41 2021/6/23
 * @Desc: Warning!Warning!!Warning!!!
 **/
@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 处理所有不可知的异常
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public OmegaRs exception(Exception e) {
        log.error("系统异常信息 ex={}", e.getMessage(), e);
        return new OmegaRs<>(e);
    }

    /**
     * 运行时异常
     *
     * @param runtimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public OmegaRs runtimeExceptionHandler(RuntimeException runtimeException) {
        log.error("系统异常信息 ex={}", runtimeException.getLocalizedMessage(), runtimeException);
        return new OmegaRs<>(runtimeException);
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public OmegaRs handleServiceException(ServiceException e) {
        //业务异常记录为info级别，不记录为error级别
        log.info("业务异常信息 ex={}", e.getMessage(), e);
        return new OmegaRs<>(
                new OmegaRsHeader(ApiErrorCodeEnum.SYS_FAILED.getCode(), ApiErrorCodeEnum.SYS_FAILED.getMessage())
                , System.currentTimeMillis()
        );
    }
}
