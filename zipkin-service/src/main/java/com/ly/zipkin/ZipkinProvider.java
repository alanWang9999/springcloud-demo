package com.ly.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @ClassName ZipkinProvider
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinProvider
{
    public static void main(String[] args) {
        SpringApplication.run(ZipkinProvider.class);
    }
}
