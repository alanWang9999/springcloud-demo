package com.ly.product.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName ProductProvider
 * @Author alan.wang   QQ:3103484396
 * @Description 商品服务的启动类
 */
@EnableScheduling
@MapperScan("com.ly.product.service.mapper")
@EnableEurekaClient
@SpringBootApplication
public class ProductProvider
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProductProvider.class);
    }
}
