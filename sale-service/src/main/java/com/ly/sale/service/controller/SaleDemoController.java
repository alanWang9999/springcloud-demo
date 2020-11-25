package com.ly.sale.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.sale.service.entity.Sale;
import com.ly.sale.service.feign.FeignStockService;
import com.ly.sale.service.mapper.SaleMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName SaleDemoController
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@Slf4j
@Controller
public class SaleDemoController {

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private FeignStockService feignStockService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @HystrixCommand(fallbackMethod = "addSaleFallback")
    @ResponseBody
    @RequestMapping("/addSale")
    public String addSale(@RequestBody Sale sale){
        String result = this.feignStockService.test();
        log.info("添加销售的入参:" + sale.toString());
        return "执行成功!";
    }
    public String addSaleFallback(@RequestBody Sale sale){
        return "请稍后重试!";
    }

    @ResponseBody
    @RequestMapping("/testRemoteStock")
    public String testRemoteStock(){
        //调用reids的get命令
        String s = stringRedisTemplate.opsForValue().get("index");
        //调用reids的set命令
        stringRedisTemplate.opsForValue().set("index" , "aaaa");


        Sale sale = new Sale();
        sale.setPrice(new BigDecimal("100"));
        System.out.println(sale.toString());

//        String result = this.restTemplate.getForEntity("http://PROJECT-STOCK/test" , String.class).getBody();
        String result = this.feignStockService.test();
        System.out.println("调用远程方法(库存服务)响应的结果:" + result);
        /** 解决register-center的bug */
        return "";
    }
    /**
     *  购买商品
     *  id:商品的编号  buyQty购买的数量
     *  在高并发情况下的超卖问题、超发问题
     *  悲观锁
     *  @return
     */
    @RequestMapping("createSaleRecord")
    @ResponseBody
    @Transactional
    public String createSaleRecord(int id , int buyQty){
        /** 根据id查商品的数量 */
        Sale sale = this.saleMapper.selectByIdForUpdate(id);
        if(sale.getQuantity().intValue() < buyQty){
            return "库存不够，请购买其他商品!";
        } else {
            this.saleMapper.reduceQty(id , buyQty);
            return "购买成功!";
        }
    }

    /**
     *  购买商品
     *  id:商品的编号  buyQty购买的数量
     *  在高并发情况下的超卖问题、超发问题
     *  乐观锁
     *  @return
     */
    @RequestMapping("createSaleRecord2")
    @ResponseBody
    @Transactional
    public String createSaleRecord2(int id , int buyQty){
        /** 根据id查商品的数量 */
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);
        Sale sale = this.saleMapper.selectOne(queryWrapper);
        if(sale.getQuantity().intValue() < buyQty){
            return "库存不够，请购买其他商品!";
        } else {
            int count = this.saleMapper.reduceQty2(id , buyQty , sale.getVersion() , UUID.randomUUID().toString());
            if(count > 0){
                return "购买成功!";
            } else {
                return "请重试!";
            }
        }
    }

    public static final String REDIS_SECOND_KILL_GOODS_PREFIX = "secondkill:stock:";
    @RequestMapping("/secondKill")
    public String secondKill(int id , int buyCount){
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<String>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua" + File.separator + "secondKill.lua")));
        redisScript.setResultType(String.class);
        List<String> keys = new ArrayList<>();
        keys.add(REDIS_SECOND_KILL_GOODS_PREFIX + id);
        String result = this.stringRedisTemplate.execute(redisScript , keys , "" + buyCount);
        System.out.println(result);
        return result;
    }
}
