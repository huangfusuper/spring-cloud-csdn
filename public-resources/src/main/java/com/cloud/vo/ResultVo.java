package com.cloud.vo;

import lombok.Data;

/**
 * 结果返回统一格式映射类
 * @author 皇甫
 * @Data 插件 自动生成getter/Setter
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo() {
    }
}
