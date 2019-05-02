package com.cloud.service.impl;

import com.cloud.entrty.Product;
import com.cloud.service.ProductFeignService;
import org.springframework.stereotype.Component;

/**
 * 商品服务降级方法
 * @author 皇甫
 */
@Component
public class ProductFeignServiceImpl implements ProductFeignService {
    @Override
    public String getProduct(String id) {
        return null;
    }

    @Override
    public String addProduct(Product product) {
        return null;
    }
}
