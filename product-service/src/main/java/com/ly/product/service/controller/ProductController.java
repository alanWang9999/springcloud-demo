package com.ly.product.service.controller;

import com.ly.commons.bo.product.ReduceProductStockBO;
import com.ly.commons.dto.ResponseData;
import com.ly.product.service.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @ClassName ProductController
 * @Author alan.wang   QQ:3103484396
 * @Description 商品的服务
 */
@Slf4j
@RestController
public class ProductController
{
    @Autowired
    private ProductMapper productMapper;

    /**
     *  商品扣减库存
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    @Transactional
    @PostMapping("/reduceQty")
    public ResponseData<Void> reduceQty(@RequestBody ReduceProductStockBO bo)
    {
        log.info("调用了扣件库存的代码!" + bo.toString());
//        try {
//            /* 线程休眠5秒，用来模拟服务执行慢，以此来引发其他服务的断路功能 */
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.productMapper.reduceStock(bo);
        return new ResponseData();
    }
    @RequestMapping("/test")
    public ResponseData<String> test(){
        return new ResponseData<>();
//        return new ResponseData<>(ResponseData.ResultCode.SUCCESS , "" , "test");
    }
}
