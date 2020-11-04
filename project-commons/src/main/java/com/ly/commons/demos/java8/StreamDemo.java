package com.ly.commons.demos.java8;

import com.ly.commons.dto.OrderItemDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo
 * @Author alan.wang   QQ:3103484396
 * @Description java8流的demo
 */
public class StreamDemo
{
    public static List<String> mapDemo(){
        List<OrderItemDTO> list = Arrays.asList(new OrderItemDTO("苹果" , new BigDecimal("50") , new BigDecimal("2")) ,
                new OrderItemDTO("香蕉" , new BigDecimal("40") , new BigDecimal("4")) ,
                new OrderItemDTO("橘子" , new BigDecimal("80") , new BigDecimal("4")) );
        /**
        List<String> goodsNameList = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : list) {
            goodsNameList.add(orderItemDTO.getGoodsName());
        }
        return goodsNameList;
         */
        /* 流中的map方法，可以用来对集合的属性进行提取，拼装成一个新的集合的流 */
        Stream<OrderItemDTO> listStream = list.parallelStream();
        Stream<String> stringStream = listStream.map(orderItemDTO -> orderItemDTO.getGoodsName());
        /* 从流转换回集合 */
        return stringStream.collect(Collectors.toList());
    }

    public static BigDecimal reduce(){
        List<OrderItemDTO> list = Arrays.asList(new OrderItemDTO("苹果" , new BigDecimal("50") , new BigDecimal("2")) ,
                new OrderItemDTO("香蕉" , new BigDecimal("40") , new BigDecimal("4")) ,
                new OrderItemDTO("橘子" , new BigDecimal("80") , new BigDecimal("4")) );
        /* 获取list所有商品的总价格  list中所有的  单价*数量  最后合计在一起
        BigDecimal total = new BigDecimal("0");
        for (OrderItemDTO orderItemDTO : list) {
            BigDecimal subtotal = orderItemDTO.getPrice().multiply(orderItemDTO.getQty());
            total = total.add(subtotal);
        }
         */
        /* 首先利用map算出小计金额 */
        BigDecimal total = new BigDecimal("0");
        Stream<BigDecimal> subtotalStream = list.parallelStream().map(orderItemDTO -> orderItemDTO.getPrice().multiply(orderItemDTO.getQty()));
        /* 使用reduce把所有的小计进行相加算出合计 */
        total = subtotalStream.reduce(total , ((bigDecimal, bigDecimal2) -> {
            System.out.println("bigDecimal:" + bigDecimal + "\tbigDecimal2:" + bigDecimal2);
            return bigDecimal.add(bigDecimal2);
        }));
        System.out.println("合计金额:" + total.toString());
        return total;
    }

    /**
     *  利用stream中的filter筛选出单价45元以上的商品
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    public static void filter(){
        List<OrderItemDTO> list = Arrays.asList(new OrderItemDTO("苹果" , new BigDecimal("50") , new BigDecimal("2")) ,
                new OrderItemDTO("香蕉" , new BigDecimal("40") , new BigDecimal("4")) ,
                new OrderItemDTO("橘子" , new BigDecimal("80") , new BigDecimal("4")) );
        //单价在45元以上的订单
        Stream<OrderItemDTO> stream = list.parallelStream();
        stream = stream.filter(orderItemDTO -> {
            return orderItemDTO.getPrice().doubleValue() > 45;
        });
        list = stream.collect(Collectors.toList());
        for (OrderItemDTO orderItemDTO : list) {
            System.out.println(orderItemDTO.getGoodsName());
        }
    }

    public static void sort()
    {
        List<OrderItemDTO> list = Arrays.asList(new OrderItemDTO("苹果" , new BigDecimal("50") , new BigDecimal("2")) ,
                new OrderItemDTO("香蕉" , new BigDecimal("40") , new BigDecimal("4")) ,
                new OrderItemDTO("橘子" , new BigDecimal("80") , new BigDecimal("4")) );
        Stream<OrderItemDTO> stream = list.stream();
        stream = stream.sorted((o1 , o2)->{
            return o2.getPrice().intValue()-o1.getPrice().intValue();
        });
        stream = stream.limit(1);
        list = stream.collect(Collectors.toList());
        for (OrderItemDTO orderItemDTO : list) {
            System.out.println(orderItemDTO.getGoodsName());
        }
    }

    public static void main(String[] args) {
        sort();
    }

}
