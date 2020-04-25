package com.ly.zikpin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @ClassName ZikpinProvider
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@SpringBootApplication
@EnableZipkinServer
public class ZikpinProvider
{
    public static void main(String[] args) {
        SpringApplication.run(ZikpinProvider.class);
    }
}
