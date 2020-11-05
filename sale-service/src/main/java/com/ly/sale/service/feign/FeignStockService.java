package com.ly.sale.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PROJECT-STOCK")
public interface FeignStockService {
    @RequestMapping("/test")
    public String test();
}
