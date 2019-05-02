package com.cloud.entrty;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品的实体类
 * @author 皇甫
 * @Data 插件 自动生成getter/Setter
 */
@Data
public class Product {
    /**
     * id
     */
    private String id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private BigDecimal price;

    public Product() {
    }

    public Product(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
