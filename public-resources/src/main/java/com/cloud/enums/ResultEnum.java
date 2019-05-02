package com.cloud.enums;

import lombok.Getter;

/**
 * 结果返回状态码 枚举
 * @author 皇甫
 */
@Getter
public enum  ResultEnum {
    SUCCESS(100,"成功"),
    PRODUCT_DOES_NOT_EXIST(101,"商品不存在")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
