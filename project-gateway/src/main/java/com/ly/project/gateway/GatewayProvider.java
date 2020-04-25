package com.ly.project.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName GatewayProvider
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayProvider
{
    public static void main(String[] args) {
        SpringApplication.run(GatewayProvider.class);
    }
}
