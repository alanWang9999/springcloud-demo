package com.ly.sale.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.io.*;
/**
 * @ClassName SaleProvider
 * @Author alan.wang   QQ:3103484396
 * @Description 销售服务的启动类
 */
@EnableEurekaClient
@MapperScan("com.ly.sale.service.mapper")
@SpringBootApplication
@EnableFeignClients
public class SaleProvider
{
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /** master分支 */
        /** register-center分支 */
        ApplicationContext ac = SpringApplication.run(SaleProvider.class);
    }
}
