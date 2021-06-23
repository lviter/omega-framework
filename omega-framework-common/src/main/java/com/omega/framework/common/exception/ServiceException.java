package com.omega.framework.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author lviter
 * @Description
 * @Date 17:30 2021/6/23
 * @Desc: Warning!Warning!!Warning!!!
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {
    private String errorKey;
    private String code;
    private String errorMessage;

    /**
     * <p>
     * Description: 构造函数
     * </p>
     *
     * @param cause 堆栈
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(String errorKey, String code, String errorMessage) {
        super(errorMessage);
        this.errorKey = errorKey;
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(BaseServiceException exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

    /**
     * 支持占位符方式动态变更枚举类中对应占位符的错误提示信息
     *
     * @param exception
     * @param placeHolderArgs
     */
    public ServiceException(BaseServiceException exception, Object... placeHolderArgs) {
        super(String.format(exception.getMessage(), placeHolderArgs));
        this.code = exception.getCode();
        this.errorMessage = super.getMessage();
    }

}
