package com.ly.user.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName UserProvider
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@MapperScan("com.ly.user.service.mapper")
@EnableEurekaClient
@SpringBootApplication
public class UserProvider
{
    public static void main(String[] args) {
        SpringApplication.run(UserProvider.class);
    }
}
