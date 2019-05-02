package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 商品服务的启动类
 * @author 皇甫
 * @SpringBootApplication SpringBoot启动类注解
 * @EnableDiscoveryClient Eureka客户端启用注解
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class);
    }
}
