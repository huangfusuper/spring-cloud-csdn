package com.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.entrty.Product;
import com.cloud.enums.ResultEnum;
import com.cloud.exception.ApplicationException;
import com.cloud.service.ProductFeignService;
import com.cloud.utils.ResultVoUtil;
import com.cloud.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 调用方API
 * @author 皇甫
 */
@RestController
@RequestMapping("user")
public class UserController {
    final String PRODUCT_ID = "1";
    @Autowired
    private ProductFeignService productFeignService;

    @GetMapping("findProduct")
    public ResultVo findProduct(@RequestParam("id") String id){
        if(PRODUCT_ID.equals(id)){
            String productJson = productFeignService.getProduct(id);
            if(StringUtils.isEmpty(productJson)){
                return ResultVoUtil.error();
            }
            Product product = JSON.parseObject(productJson, Product.class);
            return ResultVoUtil.success(product);
        }else{
            throw new ApplicationException(ResultEnum.PRODUCT_DOES_NOT_EXIST);
        }
    }
    @GetMapping("addProduct")
    public ResultVo addProduct(@RequestBody Product product){
        if(product != null){
            product = JSON.parseObject(productFeignService.addProduct(product),Product.class);
            return ResultVoUtil.success(product);
        }
        return ResultVoUtil.error("添加失败");
    }
}
