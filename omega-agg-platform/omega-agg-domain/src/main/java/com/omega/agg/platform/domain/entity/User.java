package com.omega.agg.platform.domain.entity;

import lombok.Data;

/**
 * @author: lviter
 * @desc:
 * @date:2021/12/7
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
