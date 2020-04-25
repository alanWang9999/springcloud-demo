package com.ly.order.controller;

import com.ly.commons.bo.stock.AddStockBO;
import com.ly.order.feign.StockFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @ClassName OrderController
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@RestController
public class OrderController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockFeign stockFeign;

    @RequestMapping("/testOrder")
    public String testOrder()
    {
        //这样虽然可以调用，但是写死ip和端口，1.无法使用负载均衡 2.服务一旦迁移到其他计算机或者端口号改变，就会导致服务调用失败
//        String result = restTemplate.getForEntity("http://localhost:8881/test" , String.class).getBody();
        //下方代码是利用注册中心，进行了服务调用,写的是服务名，而不是ip和端口，所以以上问题就解决了
//        String result = restTemplate.getForEntity("http://project-stock/test" , String.class).getBody();
        //下方使用feign的方式进行服务调用
        String result = this.stockFeign.test();
        result = "testOrder调用了库存的服务，返回结果:" + result;
        return result;
    }
    @RequestMapping("/testAddStock")
    public String testAddStock()
    {
        AddStockBO addStockBO = new AddStockBO();
        addStockBO.setId(1);
        addStockBO.setQty(new BigDecimal("1000"));
        String result = this.stockFeign.addStock(addStockBO);
        return result;
    }
}
