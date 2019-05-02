package com.cloud.utils;

import com.cloud.enums.ResultEnum;
import com.cloud.vo.ResultVo;

/**
 * 结果返回格式工具类
 * @author 皇甫
 */
public class ResultVoUtil {
    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultVo success(Object data){
        ResultVo<Object> resultVo = new ResultVo<Object>();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        resultVo.setData(data);
        return resultVo;
    }

    /**
     * 无参成功
     * @return
     */
    public static ResultVo success(){
        ResultVo<Object> resultVo = new ResultVo<Object>();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        return resultVo;
    }

    /**
     * 无参失败
     * @return
     */
    public static ResultVo error() {
        ResultVo<Object> resultVo = new ResultVo<Object>();
        resultVo.setCode(5000);
        resultVo.setMsg("失败");
        return resultVo;
    }
    /**
     * 有参失败
     * @return
     */
    public static ResultVo error(String msg) {
        ResultVo<Object> resultVo = new ResultVo<Object>();
        resultVo.setCode(5000);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
