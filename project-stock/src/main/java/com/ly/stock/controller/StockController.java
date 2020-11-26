package com.ly.stock.controller;

import com.ly.commons.bo.stock.AddStockBO;
import com.ly.commons.dto.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName StockController
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@Slf4j
@RestController
public class StockController
{
    /**
     *  添加库存
     *  @return
     */
    @RequestMapping("/addStock")
    public ResponseData addStock(@RequestBody List<AddStockBO> list){
        //添加库存的逻辑代码.....

        return new ResponseData(ResponseData.ResultCode.SUCCESS , "" , null);
    }

    @RequestMapping("/test")
    public String test()
    {
        log.info("测试库存服务");
        return "测试库存服务";
    }
//    @RequestMapping("/addStock")
//    public String addStock(@RequestBody AddStockBO addStockBO)
//    {
//        System.out.println("添加库存的方法被调用:" + addStockBO.getId() + "\t" + addStockBO.getQty());
//        try {
//            Thread.sleep(5000);//模拟添加库存的方法执行慢，来引发其他服务的断路
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "SUCCESS";
//    }
}
