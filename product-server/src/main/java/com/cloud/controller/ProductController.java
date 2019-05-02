package com.cloud.controller;

import com.cloud.entrty.Product;
import com.cloud.enums.ResultEnum;
import com.cloud.exception.ApplicationException;
import com.cloud.utils.ResultVoUtil;
import com.cloud.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 模拟商品查询单个商品 以及增加功能  这要是参数格式
 * @author 皇甫
 */
@RestController
@RequestMapping("product")
public class ProductController {
    final String PRODUCT_ID = "1";
    /**
     * 模拟根据商品id查询
     * @param id
     * @return
     */
    @RequestMapping("getProduct")
    public Product getProduct(@RequestParam("id") String id) throws InterruptedException {
        //Thread.sleep(2000);
        if(PRODUCT_ID.equals(id)){
            Product product = new Product(UUID.randomUUID().toString(),"皮蛋粥",new BigDecimal(100.5));
            return product;
        }else{
            throw new ApplicationException(ResultEnum.PRODUCT_DOES_NOT_EXIST);
        }
    }

    /**
     * 添加成功
     * @param product
     * @return
     */
    @RequestMapping("addProduct")
    public Product addProduct(@RequestBody Product product){
        return product;
    }
}
