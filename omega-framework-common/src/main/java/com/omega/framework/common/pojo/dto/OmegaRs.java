package com.omega.framework.common.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author lviter
 * @Description
 * @Date 15:26 2021/6/23
 * @Desc: Warning!Warning!!Warning!!!
 **/
@Data
@Accessors(chain = true)
public class OmegaRs<T> implements Serializable {

    /**
     * 响应头信息
     */
    private OmegaRsHeader header;

    /**
     * 响应体
     */
    private T data;

    /**
     * 操作时间
     */
//    @JsonProper
    private Long currentTime;

    public OmegaRs() {
    }

    public OmegaRs(T data) {
        this.data = data;
    }

    public static <T> OmegaRs<T> ok(T data) {
//        return new OmegaRs(new OmegaRsHeader("0", "SUCCESS"), data, System.currentTimeMillis());
        return (OmegaRs<T>) data;
    }
}
