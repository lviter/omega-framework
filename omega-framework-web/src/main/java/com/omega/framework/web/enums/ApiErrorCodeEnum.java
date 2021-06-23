package com.omega.framework.web.enums;

import com.omega.framework.common.exception.BaseServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author lviter
 * @Description
 * @Date 18:36 2021/6/23
 * @Desc: Warning!Warning!!Warning!!!
 **/
@Getter
@AllArgsConstructor
public enum ApiErrorCodeEnum implements BaseServiceException {
    /**
     * 成功-0，失败-1
     */
    SYS_SUCCESS("0", "成功", "执行成功"),

    SYS_FAILED("1", "执行失败", "执行失败"),

    SYS_NO_LOGIN("900100101", "没有登录", "没有登录"),

    SYS_NO_PERMISSION("900100102", "没有权限", "没有权限"),
    ;

    private final String code;
    private final String message;
    private final String remark;

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    public static ApiErrorCodeEnum getEnum(Integer code) {
        if (null == code) {
            return null;
        }

        ApiErrorCodeEnum[] ecs = ApiErrorCodeEnum.values();
        for (ApiErrorCodeEnum ec : ecs) {
            if (ec.getCode().equals(code)) {
                return ec;
            }
        }

        return null;
    }

}
