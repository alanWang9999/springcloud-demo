package com.ly.sale.service.controller;

import com.ly.sale.service.feign.FeignStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName SaleDemoController
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@Controller
public class SaleDemoController {

    @Autowired
    private FeignStockService feignStockService;

    @ResponseBody
    @RequestMapping("/testRemoteStock")
    public String testRemoteStock(){
//        String result = this.restTemplate.getForEntity("http://PROJECT-STOCK/test" , String.class).getBody();
        String result = this.feignStockService.test();
        System.out.println("调用远程方法(库存服务)响应的结果:" + result);
        return "";
    }
}
