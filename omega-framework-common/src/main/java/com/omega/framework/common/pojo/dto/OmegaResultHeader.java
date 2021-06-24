package com.omega.framework.common.pojo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author lviter
 * @Description
 * @Date 17:22 2021/6/23
 * @Desc: Warning!Warning!!Warning!!!
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class OmegaResultHeader implements Serializable {

    private static final long serialVersionUID = -6204542340640355634L;

    private String code;
    private String message;

    public OmegaResultHeader(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
