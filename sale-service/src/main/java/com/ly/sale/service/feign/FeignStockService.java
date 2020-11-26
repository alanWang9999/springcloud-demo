package com.ly.sale.service.feign;

import com.ly.commons.bo.stock.AddStockBO;
import com.ly.commons.dto.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("PROJECT-STOCK")
public interface FeignStockService {
    @RequestMapping("/test")
    public String test();

    @RequestMapping("/addStock")
    public ResponseData addStock(List<AddStockBO> list);
}
