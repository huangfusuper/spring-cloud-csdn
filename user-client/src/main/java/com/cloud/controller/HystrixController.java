package com.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.entrty.Product;
import com.cloud.enums.ResultEnum;
import com.cloud.exception.ApplicationException;
import com.cloud.utils.ResultVoUtil;
import com.cloud.vo.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 皇甫
 */
@RestController
@RequestMapping("userHystrix")
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    private final String PRODUCT_ID = "1";
    private final String PRODUCT_SERVER = "PRODUCT-SERVER";
    @Autowired
    private RestTemplate restTemplate;


    /**
     *
     * @param id
     * @return
     * @HystrixProperty
     *  execution.isolation.thread.timeoutInMilliseconds 最大延时降级时间
     *  circuitBreaker.enabled 开启熔断器
     *  circuitBreaker.requestVolumeThreshold 断路器的最小请求数10之后 计算错误阈值
     *  circuitBreaker.sleepWindowInMilliseconds 错误率达到阈值 本例60%
     *  circuitBreaker.errorThresholdPercentage 间隔多长时间开启断路器半开状态
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds" ,value ="3000" ),
            @HystrixProperty(name ="circuitBreaker.enabled" ,value ="true" ),
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold" ,value ="10" ),
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds" ,value ="60" ),
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage" ,value ="10000" ),
    })
    @GetMapping("findProduct")
    public ResultVo findProduct(@RequestParam("id") String id){
        if(PRODUCT_ID.equals(id)){
            String productJson = restTemplate.getForObject("http://"+PRODUCT_SERVER+"/product/getProduct?id="+id,String.class);
            if(StringUtils.isEmpty(productJson)){
                return ResultVoUtil.error();
            }
            Product product = JSON.parseObject(productJson, Product.class);
            return ResultVoUtil.success(product);
        }else{
            throw new ApplicationException(ResultEnum.PRODUCT_DOES_NOT_EXIST);
        }
    }

    public ResultVo defaultFallback(){
        return ResultVoUtil.success("就问你难受不难受");
    }
}
