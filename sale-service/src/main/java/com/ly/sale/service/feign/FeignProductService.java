package com.ly.sale.service.feign;

import com.ly.commons.bo.product.ReduceProductStockBO;
import com.ly.commons.dto.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("product-service")
public interface FeignProductService
{
    @PostMapping("/reduceQty")
    public ResponseData<Void> reduceQty( ReduceProductStockBO bo);
}
