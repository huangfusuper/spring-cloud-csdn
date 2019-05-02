package com.cloud.role;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 商品类的负载均衡实现
 * @author 皇甫
 */
@Configuration
public class ProductRole {
    @Bean
    public IRule productIRule(){
        return new RandomRule();
    }
}
