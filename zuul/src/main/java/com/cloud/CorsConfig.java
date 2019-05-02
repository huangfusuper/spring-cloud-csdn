package com.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域操作
 * @author 皇甫
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        //设置原始域名 http://localhost:7000/product/getProduct
        config.setAllowedOrigins(Arrays.asList("*"));
        //设置过滤那些方法 GET POST等
        config.setAllowedMethods(Arrays.asList("*"));
        //允许的头信息
        config.setAllowedHeaders(Arrays.asList("*"));
        //跨域请求的缓存时间
        config.setMaxAge(300L);
        //对那些域名进行跨域处理
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
