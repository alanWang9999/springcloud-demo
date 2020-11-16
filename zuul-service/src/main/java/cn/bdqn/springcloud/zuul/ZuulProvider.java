package cn.bdqn.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ZuulProvider
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulProvider
{
    public static void main(String[] args) {
        SpringApplication.run(ZuulProvider.class);

    }
}
