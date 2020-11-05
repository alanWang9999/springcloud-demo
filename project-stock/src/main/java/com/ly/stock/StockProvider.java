package com.ly.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName StockProvider
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@EnableEurekaClient
@SpringBootApplication
public class StockProvider
{
    public static void main(String[] args) {
        SpringApplication.run(StockProvider.class);
    }
}
