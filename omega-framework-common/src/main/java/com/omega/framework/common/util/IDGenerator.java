package com.omega.framework.common.util;

import java.util.UUID;

/**
 * @Author lviter
 * @Description
 * @Date 17:54 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class IDGenerator {
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String getUUID32() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
