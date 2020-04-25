package com.ly.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderProvider
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderProvider
{
    /* @LoadBalanced:在使用restTemplate请求时，会首先把域信息拿出来在服务列表中找，如果找到了，就把域信息替换成
     * ip和端口，如果对应的服务有多个实例，同时进行负载均衡处理 */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(OrderProvider.class);
    }
}
