package com.omega.agg.platform.interfaces.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: lviter
 * @desc:
 * @date:2021/11/23
 */
@Data
@ApiModel(value = "用户登录后获取基础信息")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO implements Serializable {

    /**
     * roles: ['admin'],
     * introduction: 'I am a super administrator',
     * avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
     * name: 'Super Admin'
     */
    private static final long serialVersionUID = 1L;

    private List<String> roles;

    private String introduction;

    private String avatar;

    private String name;
}
