package com.omega.framework.web.enums;

import com.omega.framework.common.exception.BaseServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author lviter
 * @Description
 * @Date 18:39 2021/6/23
 * @Desc: Warning!Warning!!Warning!!!
 **/
@Getter
@AllArgsConstructor
public enum TokenExceptionEnum implements BaseServiceException {
    TOKEN_EXPIRED("900100301", "token过期", "token过期"),
    TOKEN_ERROR("900100302", "token验证失败", "token验证失败"),
    TOKEN_INVALID("900100303", "Token无效", "Token无效(Token解析出现的各种异常)"),
    TOKEN_TYPE_INVALID("900100304", "Token无效", "Token无效(Token类型为空或Token类型无效)"),
    TOKEN_NULL("900100305", "Token无效", "Token无效(Token为空)"),
    TOKEN_ALGORITHM_NULL("900100306", "Token无效", "Token无效(未指定加密算法)"),
    TOKEN_PUBLIC_KEY_ILLEGAL("900100307", "Token无效", "Token无效(公钥无效)"),
    TOKEN_PRIVATE_KEY_ILLEGAL("900100308", "Token无效", "Token无效(私钥无效)"),
    TOKEN_INVALID_PRIVILEGE_ACCESS_FORBIDDEN("900100309", "Token无效", "Token无效(禁止访问，没有访问该资源的权限)"),
    TOKEN_INVALID_LOGIN_USER_NULL("900100310", "Token无效", "Token无效(用户信息不存在，无法成功解析出可用的用户信息)"),
    ;

    private String code;
    private String message;
    private final String remark;

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
