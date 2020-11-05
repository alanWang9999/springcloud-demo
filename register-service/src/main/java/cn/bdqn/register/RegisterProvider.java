package cn.bdqn.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName RegisterProvider
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterProvider
{
    public static void main(String[] args) {
        SpringApplication.run(RegisterProvider.class);
    }
}
