package com.ly.order.feign;

import com.ly.commons.bo.stock.AddStockBO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("project-stock")
public interface StockFeign
{
    @RequestMapping("/test")
    public String test();

    @RequestMapping("/addStock")
    public String addStock(AddStockBO addStockBO);
}
