package com.cloud.service;

import com.cloud.entrty.Product;
import com.cloud.service.impl.ProductFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用商品服务
 * @author 皇甫
 * @FeignClient feign组件
 *      name:要调用的服务名称
 *      fallback: 调用失败后的降级方法
 */
@FeignClient(value = "PRODUCT-SERVER",fallback = ProductFeignServiceImpl.class)
public interface ProductFeignService {
    /**
     * 调用商品服务
     * @param id
     * @return
     *  @GetMapping value="要调用的方法路径"
     */
    @RequestMapping("/product/getProduct")
    String getProduct(@RequestParam("id") String id);

    /**
     * TODO 重点-------------------------------------------
     * 这里注意 RequestBody 标注的参数，其访问类型必须为POST方式
     * TODO 重点-------------------------------------------
     * @param product
     * @return
     */
    @RequestMapping("product/addProduct")
    String addProduct(@RequestBody Product product);
}
