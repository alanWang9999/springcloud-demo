package com.ly.sale.service;

import com.Student;
import com.ly.sale.service.entity.Sale;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.client.RestTemplate;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SaleProvider
 * @Author alan.wang   QQ:3103484396
 * @Description 销售服务的启动类
 */
@EnableHystrix
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

//        StringRedisTemplate stringRedisTemplate = ac.getBean(StringRedisTemplate.class);
//        DefaultRedisScript<String> redisScript = new DefaultRedisScript<String>();
//        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua" + File.separator + "test.lua")));
//        redisScript.setResultType(String.class);
//        List<String> keys = new ArrayList<>();
//        keys.add("key1");
//        String code = stringRedisTemplate.execute(redisScript, keys, "100");
//        System.out.println(code);
    }
}
