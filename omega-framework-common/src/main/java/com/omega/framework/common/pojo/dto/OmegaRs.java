package com.omega.framework.common.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omega.framework.common.exception.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OmegaRs<T> implements Serializable {

    private static final long serialVersionUID = -6204542340640355634L;

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
    @JsonProperty("current_time")
    private Long currentTime;

    public OmegaRs(T data) {
        this.data = data;
    }

    public OmegaRs(OmegaRsHeader header, Long currentTime) {
        this.header = header;
        this.currentTime = currentTime;
    }

    /**
     * @param data
     * @param <T>
     * @return
     */
    public static <T> OmegaRs<T> ok(T data) {
        return new OmegaRs<>(
                new OmegaRsHeader(AbstractRs.Status.SUCCESS.getFlag(), AbstractRs.Status.SUCCESS.getMessage()), data, System.currentTimeMillis()
        );
    }

    /**
     * @param se
     * @param <T>
     * @return
     */
    public static <T> OmegaRs<T> fail(ServiceException se) {
        return new OmegaRs<>(
                new OmegaRsHeader(se.getCode(), se.getErrorMessage()), null, System.currentTimeMillis()
        );
    }

}
