package com.ly.sale.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @ClassName SaleProvider
 * @Author alan.wang   QQ:3103484396
 * @Description 销售服务的启动类
 */
@MapperScan("com.ly.sale.service.mapper")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SaleProvider
{
    public static void main(String[] args) {
        SpringApplication.run(SaleProvider.class);
    }
}
