package com.cloud;

import com.cloud.role.ProductRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 调用方服务启动类
 * @author 皇甫
 * @SpringBootApplication SpringBoot启动类注解
 * @EnableDiscoveryClient Eureka客户端启用注解
 * @EnableFeignClients feign组件 开启远程方法调用
 * @RibbonClients 为指定的服务提供精准负载均衡策略
 *      @RibbonClient
 *          name：服务名称
 *          configuration：自定义负载均衡类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.cloud.service"})
@RibbonClients({
        @RibbonClient(name = "PRODUCT-SERVER",configuration = ProductRole.class)
})
@EnableCircuitBreaker
public class UserClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class);
    }
}
