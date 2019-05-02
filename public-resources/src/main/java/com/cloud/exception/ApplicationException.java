package com.cloud.exception;

import com.cloud.enums.ResultEnum;

/**
 * 本工程出现的自定义异常
 * @author 皇甫
 */
public class ApplicationException extends RuntimeException {
    private Integer code;
    public ApplicationException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
