package com.omega.framework.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class AbstractResult implements Serializable {

    private static final long serialVersionUID = -6204542340640355634L;

    @Getter
    @AllArgsConstructor
    public enum Status {

        SUCCESS("1", "SUCCESS"),
        FAILURE("0", "FAILURE");

        private final String flag;
        private final String message;
    }

}
