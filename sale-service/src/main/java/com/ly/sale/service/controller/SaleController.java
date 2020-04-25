package com.ly.sale.service.controller;

import com.ly.commons.bo.product.ReduceProductStockBO;
import com.ly.commons.bo.sale.AddSaleBO;
import com.ly.commons.dto.QuerySale;
import com.ly.commons.dto.ResponseData;
import com.ly.commons.dto.UserDTO;
import com.ly.commons.utils.JwtUtils;
import com.ly.sale.service.entity.Sale;
import com.ly.sale.service.feign.FeignProductService;
import com.ly.sale.service.mapper.SaleMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName SaleController
 * @Author alan.wang   QQ:3103484396
 * @Description 销售的相关业务
 */
//S2学过日志框架: LOG4J   springboot使用的日志框架是: logback
/**
 * slf4j：是一套日志框架的接口，slf4j不提供日志的具体实现，但是其他的日志框架都实现了slf4j的接口，
 * 所以我们在代码中可以直接使用slf4j，将来切换日志框架，也不需要修改代码
 */
@Slf4j
@RestController
public class SaleController
{
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private FeignProductService feignProductService;

    /**
     *  新增销售
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    //设定在方法执行超时或者出现异常时，执行的断路方法（断路方法必须保证方法的返回值和入参与addSale保持一致）
    @HystrixCommand(fallbackMethod = "addSaleBack")
    @PostMapping("/addSale")
    public ResponseData<Void> addSale(@RequestBody AddSaleBO addSaleBO)
    {
        //log.info("添加销售记录:" + addSaleBO.toString());
        System.out.println("添加销售记录的源方法！");
        Sale entity = new Sale();
        BeanUtils.copyProperties(addSaleBO , entity);
        //计算总价格
        //BigDecimal在进行小数的+-*/运算时，不会出现精度缺失问题，（float和double会出现精度缺失问题）
        //BigDecimal通过方法调用的方式来进行运算
        BigDecimal total = addSaleBO.getPrice().multiply(new BigDecimal(addSaleBO.getQuantity().toString()));
        entity.setTotalprice(total);
        entity.setSaledate(new Date());
        this.saleMapper.insert(entity);

        //扣件库存
        ReduceProductStockBO reduceProductStockBO = new ReduceProductStockBO();
        reduceProductStockBO.setId(addSaleBO.getProductid());
        reduceProductStockBO.setReduceCount(addSaleBO.getQuantity());
//        log.debug("开始远程调用扣减库存的服务---->product-service:reduceQty");
        this.feignProductService.reduceQty(reduceProductStockBO);
//        log.debug("product-service:reduceQty调用成功！");

        return new ResponseData<>();
    }
    /**
     *  熔断(断路)方法,处理源方法超时或者出错时，执行此方法
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    public ResponseData<Void> addSaleBack(@RequestBody AddSaleBO addSaleBO){
        System.out.println("回路方法执行");
        return new ResponseData<>(ResponseData.ResultCode.FAIL , "出现异常，请稍后再试" , null);
    }
    /**
     *  查询当前登录用户的销售记录
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    @PostMapping("/querySaleByLoginUser")
    public ResponseData<QuerySale> querySaleByLoginUser()
    {
        UserDTO userDTO = JwtUtils.loginedUserIdByToken();
        System.out.println("当前登录用户是：" + userDTO.toString());
        /* 根据登录的用户，查询数据 */
        return new ResponseData<QuerySale>(new QuerySale());
    }

}
